package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.ChampComplete;
import glp.domain.Role;
import glp.domain.Champ;
import glp.domain.Utilisateur;
import glp.form.AnnonceForm;
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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/annonce")
public class AnnonceController {
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

	public AnnonceController() {
	}

	
	/**
	 * pour la création d'une annonce
	 * 1er form qui demande d'abord la categorie
	 * @return
	 */
	@RequestMapping(value="new/categoriechoice", method=RequestMethod.GET)
	public ModelAndView getCategorieChoice() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catlist", categorieService.getList());
		myModel.put("annform", new AnnonceForm());
		
		return new ModelAndView("ann_form_select_cat", myModel);
	}
	
	/**
	 * 
	 * @param annform
	 * @return le formulaire de création d'une annonce, après que l'on ait choisi une catégorie
	 */
	@RequestMapping("new/form")
	public ModelAndView getForm(@ModelAttribute("annform") AnnonceForm annform) {
		
		//si on arrive sur le formulaire sans passer par le choix de catégorie --> redirige
		if(annform.getCat_choisie()==null)
			return getCategorieChoice();
		
		else {		
			annform.setAnnonce(new Annonce());
			annform.getAnnonce().setCategorie(annform.getCat_choisie());
			annform = ccService.generateForAnnForm(annform);
			
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("annform", annform);
			myModel.put("roleList",  roleService.getList());
			myModel.put("utilisateur", new Utilisateur());
	//		myModel.put("utilisateur", utilisateurService.getUserInSession());
			
			
			return new ModelAndView("ann_form", myModel);
		}
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


	@RequestMapping(value = "new/addAnn", method = RequestMethod.GET)
	public ModelAndView addAnnonce(@ModelAttribute("annform") /*@Valid*/ AnnonceForm annform/*, BindingResult bindingResult*/) {

//		if (bindingResult.hasErrors()) {
//			Utilisateur utilisateur = utilisateurService.getUserInSession();
//			List<Categorie> catList = categorieService.getList();
//			Map<String, Object> myModel = new HashMap<String, Object>();
//			myModel.put("catList", catList);
//			myModel.put("utilisateur", utilisateur);
//			System.out.println(bindingResult.getFieldErrorCount());
//			System.out.println("TEST OK YA DES ERREURS");
//			return new ModelAndView("ann_form", myModel);
//		}
//		
//		else {
			Annonce ann_tmp = annform.getAnnonce();
			
			//---- A REMETTRE ---
//			ann_tmp.setAuteur(utilisateurService.getUserInSession());
		
			annform.getAnnonce().setAuteur(utilisateurService.getRowById(1));
			annonceService.insertRow(ann_tmp);
				 
			for(ChampComplete cc : ann_tmp.getChampscompletes())
			{
				cc.setAnn(ann_tmp);
				ccService.insertRow(cc);
			}
		
			return new ModelAndView("redirect:/");
//		}
	}
	

/*
	@RequestMapping("/addAnn") //@RequestParam(value="file", required = false) MultipartFile file
	public ModelAndView addAnnonce(@ModelAttribute("annonce") @Valid Annonce ann,  @RequestParam("file") MultipartFile file) {
		ann.setAuteur(utilisateurService.getUserInSession());
		annonceService.insertRow(ann);
		
		System.out.println("fffffahkdaoianjazofffffffff"+file.getName());
		if (!file.isEmpty()) {
			 try {
               byte[] bytes = file.getBytes();
               String rootPath = "C:/Users/hadhri/git/projet/src/main/webapp/resources/img";
               // Create the file on server
               String nomImage = file.getName();
               System.out.println(ann.getId()+"dknfsfnsfnslfnsflsnlfdfl");
               System.out.println(nomImage + " ejkeozjoie boh"+file.getName()+"hellooooooooo chat");
               File serverFile = new File(rootPath
                     + File.separator + ann.getId()+".png");
               System.out.println(serverFile);
             BufferedOutputStream stream = new BufferedOutputStream(
                     new FileOutputStream(serverFile));
             stream.write(bytes);
             stream.close();
			 }catch(Exception e){
			            	e.getMessage();
			 }
			
		}
		return new ModelAndView("redirect:/");
		// return "ann_list";
	}
*/
	

	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getAnnList() {
		List<Annonce> annList = annonceService.getList();
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

}
