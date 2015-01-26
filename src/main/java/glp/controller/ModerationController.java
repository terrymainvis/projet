package glp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Role;
import glp.services.AnnonceService;
import glp.services.RoleService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moderation")
public class ModerationController {
	
	@Autowired
	private AnnonceService annonceService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("addModerateur")
	public ModelAndView addModerateur() {
		return new ModelAndView("");
	}
	
	@RequestMapping("listModerateur")
	public ModelAndView ListeModerateurs() {
		return new ModelAndView("");
	}
	
	@RequestMapping("/valider/annonce/{id}")
	public ModelAndView validerAnnonce(@PathVariable("id") int idAnnSelected) {
		Annonce ann = annonceService.getRowById(idAnnSelected);
		ann.setValide(true);
		annonceService.updateRow(ann);
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("/refuser/annonce/{id}")
	public ModelAndView refuserAnnonce(@PathVariable("id") int idAnnSelected) {
		Annonce ann = annonceService.getRowById(idAnnSelected);
		ann.setValide(false);
		annonceService.updateRow(ann);
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("list")
	public ModelAndView getListAnnoncesAModerer() {
		Map<String, Object> modelAnnoncesAModerer = new HashMap<String, Object>();
		modelAnnoncesAModerer.put("roleList", roleService.getList());
		modelAnnoncesAModerer.put("utilisateur", utilisateurService.getUserInSession());
		modelAnnoncesAModerer.put("annonceList", annonceService.getListAModerer());
		return new ModelAndView("listeAnnoncesAModerer", modelAnnoncesAModerer);
	}
	

}