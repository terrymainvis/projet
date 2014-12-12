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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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

	
	@RequestMapping(value = "new")
	public ModelAndView getAnnForm(@ModelAttribute Annonce ann) {
		Utilisateur utilisateur = utilisateurService.getUserInSession();
		List<Categorie> catList = categorieService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catList", catList); myModel.put("utilisateur", utilisateur);
		
		return new ModelAndView("ann_form", myModel);
	}
	
	@RequestMapping(value = "/updateMailUtilisateur", method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK) /*permet l'appel AJAX */
	public void updateMailUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		Utilisateur u = utilisateurService.getUserInSession();
		
		u.setMailAutre(utilisateur.getMailAutre());
		u.setContactAutreMail(utilisateur.isContactAutreMail());

		utilisateurService.updateRow(u);
	}

	@RequestMapping("/addAnn")
	public ModelAndView addAnnonce(@ModelAttribute("annonce") @Valid Annonce ann) {
		annonceService.insertRow(ann);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("list")
	public ModelAndView getAnnList() {
		List<Annonce> annList = annonceService.getList();
		return new ModelAndView("ann_list", "annList", annList);
	}
	@RequestMapping("{id}")
	public ModelAndView getAnnonce(@PathVariable("id") int idAnnSelected){
		Annonce annonce = annonceService.getRowById(idAnnSelected);
		System.out.println(annonce.getId());
		return new ModelAndView("consultAnn","annonce",annonce);
	}
	
	

}
