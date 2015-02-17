package glp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import glp.domain.Annonce;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.RoleService;
import glp.services.UtilisateurService;
import glp.util.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	private CategorieService categorieService;
	
	
	@RequestMapping("/valider/annonce/{id}")
	public ModelAndView validerAnnonce(@PathVariable("id") int idAnnSelected) {
//		if(utilisateurService.isModerateur(utilisateurService.getUserInSession()) || utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Annonce ann = annonceService.getRowById(idAnnSelected);
			ann.setValide(true);
			annonceService.updateRow(ann);
//		}
			// string à externaliser dans un fichier afin d'avoir la transaction fr/en
			String content = "Votre annonce a bien été validée par notre modérateur. A bientot sur Lille 1 Community !";
			EmailSender.sendMail(ann.getAuteur().getMailLille1(), utilisateurService
					.getUserInSession().getMailLille1(), content, ann);
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("/refuser/annonce/{id}")
	public ModelAndView refuserAnnonce(@PathVariable("id") int idAnnSelected) {
//		if(utilisateurService.isModerateur(utilisateurService.getUserInSession()) || utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Annonce ann = annonceService.getRowById(idAnnSelected);
			ann.setValide(false);
			annonceService.updateRow(ann);
//		}
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("list")
	public ModelAndView getListAnnoncesAModerer() {
		Map<String, Object> modelAnnoncesAModerer = new HashMap<String, Object>();
		modelAnnoncesAModerer.put("roleList", roleService.getList());
		modelAnnoncesAModerer.put("utilisateur", utilisateurService.getUserInSession());
		modelAnnoncesAModerer.put("catList", categorieService.getList());
//		if(utilisateurService.isModerateur(utilisateurService.getUserInSession()) || utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			modelAnnoncesAModerer.put("annonceList", annonceService.getListAModerer());
//		}
		return new ModelAndView("mod_listeAnnonces", modelAnnoncesAModerer);
	}
	

}