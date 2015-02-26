package glp.controller;

import glp.domain.Annonce;
import glp.domain.Stats;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.RoleService;
import glp.services.UtilisateurService;
import glp.util.EmailSender;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("/refuser/annonce/{id}")
	public ModelAndView refuserAnnonce(@PathVariable("id") int idAnnSelected,
			HttpServletRequest request) {
//		if(utilisateurService.isModerateur(utilisateurService.getUserInSession()) || utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Annonce ann = annonceService.getRowById(idAnnSelected);
			ann.setValide(false);
			
			String motif = request.getParameter("motif");
			String content = "Bonjour, votre annonce intitulée : " + ann.getTitre() + "\n\n"
					 + "dont la description est la suivante \n\n" + ann.getDesc() + "\n\n\n"
					 + "a été modérée pour le motif suivant : " + motif;
			
			
			
			EmailSender.sendMail(ann.getAuteur().getMailLille1(), "Lille1Community", content, ann);
			
			
			annonceService.deleteRow(ann.getId());
//		}
		return getListAnnoncesAModerer();
	}
	
	@RequestMapping("list")
	public ModelAndView getListAnnoncesAModerer() {
		Map<String, Object> modelAnnoncesAModerer = new HashMap<String, Object>();
		modelAnnoncesAModerer.put("utilisateur", utilisateurService.getUserInSession());
		modelAnnoncesAModerer.put("catList", categorieService.getList());
//		if(utilisateurService.isModerateur(utilisateurService.getUserInSession()) || utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			modelAnnoncesAModerer.put("annonceList", annonceService.getListAModerer());
//		}
		return new ModelAndView("mod_listeAnnonces", modelAnnoncesAModerer);
	}
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ModelAndView afficheStatistique(){
		int nbUser = utilisateurService.nbUtilisateur();
		int nbAnnonceEnligne= annonceService.nbAnnonceEnLigne();		
		Stats stats = annonceService.getStats();
		
		 Map<String, Integer> annonceByCat = annonceService.getNbByCategorie();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annonceByCat", annonceByCat);
		myModel.put("nbUser", nbUser);
		myModel.put("nbAnnonceEnligne", nbAnnonceEnligne);
		myModel.put("nbAnnCrees", stats.getStats_nb_ann_crees());
		myModel.put("stats", stats);

		return new ModelAndView("statistique", myModel);
	}
	

}