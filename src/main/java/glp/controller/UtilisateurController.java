package glp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Job;
import glp.domain.Utilisateur;
import glp.services.CategorieService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.glassfish.external.statistics.annotations.Reset;


@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private CategorieService categorieService;

	//	@RequestMapping("/")
	//	public ModelAndView getIndex() {
	//		return new ModelAndView("index");
	//	}

	@RequestMapping("new")
	public ModelAndView getAnnForm(@ModelAttribute Utilisateur uti) {
		return new ModelAndView("uti_form");
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("utilisateur") Utilisateur uti) {
		utilisateurService.insertRow(uti);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "ModifCompte", method = RequestMethod.GET)
	public ModelAndView getFormulaireJob(@ModelAttribute Job job) {
		Utilisateur utilisateur = utilisateurService.getUserInSession();
		Utilisateur util =utilisateurService.getRowById(1);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("utilisateurConnecte", util);
		List<Categorie> catList = categorieService.getList();

		myModel.put("catList", catList);
		return new ModelAndView("user_update", myModel);
	}

	@RequestMapping(value = "monCompte", method = RequestMethod.GET)
	public ModelAndView getAnnListValides() {
		Utilisateur util =utilisateurService.getRowById(1);
		//		 Utilisateur util = utilisateurService.getRowById(utilisateurService.getUserInSession().getId());
		//		List <Annonce> listePublie = utilisateurService.listAnnoncePublie(utilisateurService.getUserInSession());

		List <Annonce> listePublie = utilisateurService.listAnnoncePublie(util);
		List <Annonce> listeAmoderer=utilisateurService.listAnnonceEnCourModeration(util);
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("utilisateurConnecte", util);
		myModel.put("catList", catList);
		myModel.put("listePublie", listePublie);
		myModel.put("listeAmoderer", listeAmoderer);

		return new ModelAndView("voirCompte",myModel);
	}



	
	@RequestMapping(value = "SupprimerAnnonceUtilisateur", method = RequestMethod.GET)
	public ModelAndView SupprimerAnnonceUtilisateur(@RequestParam(required =false) String idAnnonce) {
		Utilisateur util =utilisateurService.getRowById(1);
int identifiant = Integer.parseInt(idAnnonce);
		utilisateurService.supprimerAnnonce(identifiant);
		List <Annonce> listePublie = utilisateurService.listAnnoncePublie(util);
		List <Annonce> listeAmoderer=utilisateurService.listAnnonceEnCourModeration(util);
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("utilisateurConnecte", util);
		myModel.put("catList", catList);
		myModel.put("listePublie", listePublie);
		myModel.put("listeAmoderer", listeAmoderer);
		
		
		return new ModelAndView("voirCompte",myModel);

		
	}
	
	
	@RequestMapping(value="update")/*@RequestParam(value="file", required = false) MultipartFile file*/
	public ModelAndView addJob(Model model ,@RequestParam String nom,
											@RequestParam String prenom,
											@RequestParam String tel,
											@RequestParam String mail,
											@RequestParam String mailautre) {
		//int idUtilisateur= utilisateurService.getUserInSession().getId();
utilisateurService.updateUser(1, nom, prenom, tel, mail, mailautre)	;
		
		return new ModelAndView("redirect:/");
		//return new ModelAndView("redirect:/");
	}
}

