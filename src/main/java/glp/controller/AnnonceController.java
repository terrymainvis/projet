package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.UtilisateurService;
import glp.util.AnnonceValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

		return new ModelAndView("ann_form", myModel);
	}
	
	@RequestMapping(value = "typechoice", method = RequestMethod.GET)
	public ModelAndView getTypeChoix() {
		return new ModelAndView("ann_type_choix");
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

	@RequestMapping(value = "/addAnn", method = RequestMethod.POST)
	public ModelAndView addAnnonce(
			@ModelAttribute("annonce") @Valid Annonce ann,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
//			Utilisateur utilisateur = utilisateurService.getUserInSession();
//			List<Categorie> catList = categorieService.getList();
//			Map<String, Object> myModel = new HashMap<String, Object>();
//			myModel.put("catList", catList);
//			myModel.put("utilisateur", utilisateur);
			System.out.println(bindingResult.getFieldErrorCount());
			System.out.println("TEST OK YA DES ERREURS");
			// return "ann_form";
//			return new ModelAndView("ann_form", myModel);
			return getAnnForm(ann);
		}

		ann.setAuteur(utilisateurService.getUserInSession());
		annonceService.insertRow(ann);
		return new ModelAndView("redirect:/");
		// return "ann_list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getAnnList() {
		List<Annonce> annList = annonceService.getList();
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annList", annList);
		myModel.put("catList", catList);
		return new ModelAndView("ann_list",myModel);
	}

	@RequestMapping("{id}")
	public ModelAndView getAnnonce(@PathVariable("id") int idAnnSelected) {
		Annonce annonce = annonceService.getRowById(idAnnSelected);
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annonce", annonce);
		myModel.put("catList", catList);
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
		return new ModelAndView("ann_list", myModel);
	}

}
