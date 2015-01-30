package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.ChampCompleteService;
import glp.services.RoleService;
import glp.services.UtilisateurService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/annonce")
public class AnnonceController implements ServletContextAware{
	@Autowired
	private AnnonceService annonceService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ChampCompleteService ccService;
	
	private ServletContext servletContext;

	public AnnonceController() {
	}


	// Renvoie sur le formulaire de creation dune annonce en transmettant la
	// liste des categorie et l'utilisateur courant
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView getAnnForm(@ModelAttribute Annonce ann) {
		Utilisateur utilisateur = utilisateurService.getUserInSession();
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catList", catList);
		myModel.put("utilisateur", utilisateur);
		myModel.put("roleList",  roleService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("ann_form", myModel);
	}
				
	
	@RequestMapping(value = "typechoice", method = RequestMethod.GET)
	public ModelAndView getTypeChoix() {

		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("roleList",  roleService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		myModel.put("catList", catList);
		return new ModelAndView("ann_type_choix", myModel);

	}

	@RequestMapping(value = "/updateMailUtilisateur", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	/* permet l'appel AJAX */
	public void updateMailUser(
			@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		Utilisateur u = utilisateurService.getUserInSession();

		u.setMailAutre(utilisateur.getMailAutre());
		u.setContactAutreMail(utilisateur.isContactAutreMail());

		utilisateurService.updateRow(u);
	}



	@RequestMapping("/addAnn")/*@RequestParam(value="file", required = false) MultipartFile file*/
	public ModelAndView addAnnonce(@ModelAttribute("annonce") @Valid Annonce ann,  @RequestParam("file") MultipartFile file) {
		ann.setAuteur(utilisateurService.getUserInSession());
		annonceService.insertRow(ann);
		System.out.println("fffffahkdaoianjazofffffffff"+file.getName());
		if (!file.isEmpty()) {
			 try {
               byte[] bytes = file.getBytes();
               String rootPath = "C:/Users/hadhri/git/projet/src/main/webapp/resources/img";
               String rootPath1 = servletContext.getRealPath("resources/img");
               // Create the file on server
               String nomImage = file.getName();
               System.out.println(ann.getId()+"dknfsfnsfnslfnsflsnlfdfl");
               System.out.println(nomImage + " ejkeozjoie boh"+file.getName()+"hellooooooooo chat");
               File serverFile = new File(rootPath1 + File.separator + ann.getId()+".png");
               System.out.println(serverFile);
             BufferedOutputStream stream = new BufferedOutputStream(
                     new FileOutputStream(serverFile));
             System.out.println("IMAGE CREEE");
             stream.write(bytes);
             stream.close();
			 }catch(Exception e){
			            	e.getMessage();
			 }
			
		}
		return new ModelAndView("redirect:/");
		// return "ann_list";
	}
	

//	@RequestMapping(value = "list", method = RequestMethod.GET)
//	public ModelAndView getAnnList() {
//		List<Annonce> annList = annonceService.getList();
//		List<Categorie> catList = categorieService.getList();
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("annList", annList);
//		myModel.put("catList", catList);
//		myModel.put("roleList",  roleService.getList());
//		myModel.put("utilisateur", utilisateurService.getUserInSession());
//		return new ModelAndView("ann_list",myModel);
//	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getAnnListValides() {
		List<Annonce> annList = annonceService.getListValides();
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annList", annList);
		myModel.put("catList", catList);
		myModel.put("roleList",  roleService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("ann_list",myModel);
	}

	@RequestMapping("{id}")
	public ModelAndView getAnnonce(@PathVariable("id") int idAnnSelected) {
		Annonce annonce = annonceService.getRowById(idAnnSelected);
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annonce", annonce);
		myModel.put("catList", catList);
		myModel.put("champscompletes", ccService.getListByAnn(annonce));
		myModel.put("roleList",  roleService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("consultAnn", myModel);
	}

	@RequestMapping(value = "recherche", method = RequestMethod.GET)
	public ModelAndView getAnnListMot(@RequestParam String cat,
			@RequestParam String motCle) {
		List<Annonce> annList = annonceService.getListByCatEtMot(cat, motCle);
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annList", annList);
		myModel.put("catList", catList);
		myModel.put("roleList",  roleService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("ann_list", myModel);
	}
	
	@RequestMapping("/{id}/contact")
	public ModelAndView getContactForm() {
		System.out.println("okok");
		return new ModelAndView("contact_form");
	}
	
//	@RequestMapping("/{id}/sendmail")
//	public ModelAndView sendMail(@PathVariable("id") int idAnnSelected) {
//		Annonce annonce = annonceService.getRowById(idAnnSelected);
//		sendMail(annonce.getAuteur().getMailLille1()
//				, utilisateurService.getUserInSession().getMailLille1()
//				, "Interet pour l'annonce " + annonce.getId()  + " : " + annonce.getTitre()
//				,"COUCOU");
//		System.out.println(annonce.getAuteur().getMailLille1());
//		System.out.println("test");
//		return new ModelAndView("redirect:/");
//	}
//	
//	private void sendMail(String mailTo, String mailFrom, String content, String subject){
//		SimpleMailMessage mail = new SimpleMailMessage()
//		
//		mail.setTo(mailTo);
//		mail.setFrom(mailFrom);
//		mail.setSubject(subject);
//		mail.setText(content);
//		
//		
//		
//		
//		 MailSender mailSender;
//		 SimpleMailMessage msg = new SimpleMailMessage();
//	        msg.setTo(mailTo);
//	        msg.setText(content);
//	        try{
//	            mailSender.send(msg);
//	        }
//	        catch (MailException ex) {
//	            System.err.println(ex.getMessage());
//	        }
//	}


	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
		
	}

}
