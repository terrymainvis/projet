package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.UtilisateurService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnonceController {
	@Autowired
	private AnnonceService annonceService;
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	
	@RequestMapping(value = "ann_form")
	public ModelAndView getAnnForm(@ModelAttribute Annonce ann) {
		Utilisateur user = utilisateurService.getUserInSession();
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catList", catList); myModel.put("current_user", user);
		
		return new ModelAndView("ann_form", myModel);
	}

	@RequestMapping("/addAnn")
	public ModelAndView addAnnonce(@ModelAttribute("annonce") @Valid Annonce ann) {
		annonceService.insertRow(ann);
		return new ModelAndView("redirect:ann_list");
	}

	@RequestMapping("ann_list")
	public ModelAndView getAnnList() {
		List<Annonce> annList = annonceService.getList();
		return new ModelAndView("ann_list", "annList", annList);
	}

}
