package glp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import glp.domain.Role;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.RoleService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administration")
public class AdministrationController {
	
	@Autowired
	private AnnonceService annonceService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private CategorieService categorieService;
	
	@RequestMapping("/list")
	public ModelAndView getListeUtilisateurs(Map<String, Object> modelListeUtilisateurs) {
		if(modelListeUtilisateurs==null)
			modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			List<Utilisateur> listeAdmin = new ArrayList<Utilisateur>();
			List<Utilisateur> listeMod = new ArrayList<Utilisateur>();
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			listeAdmin = utilisateurService.getListByRole(roleService.getRowByNom("ADMINISTRATEUR").getId());
			listeMod = utilisateurService.getListByRole(roleService.getRowByNom("MODERATEUR").getId());
			listeUtilisateur = utilisateurService.getListByRole(roleService.getRowByNom("UTILISATEUR").getId());
			modelListeUtilisateurs.put("listeUtilisateursAdmin", listeAdmin);
			modelListeUtilisateurs.put("listeUtilisateursMod", listeMod);
			modelListeUtilisateurs.put("listeUtilisateurs", listeUtilisateur);
			modelListeUtilisateurs.put("roleList", roleService.getList());
			modelListeUtilisateurs.put("utilisateur", utilisateurService.getUserInSession());
			modelListeUtilisateurs.put("catList", categorieService.getList());
//		}
		return new ModelAndView("admin_listeUtilisateurs", modelListeUtilisateurs);
	}
	
	@RequestMapping("/modifierEnAdmin/{id}")
	public ModelAndView modifierEnAdmin(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			uti.setRoleId(roleService.getRowByNom("ADMINISTRATEUR").getId());
			utilisateurService.updateRow(uti);
			modelListeUtilisateurs.put("changementStatut", "administrateur");
			modelListeUtilisateurs.put("utilisateurSelectionne", uti.getMailLille1());
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/modifierEnMod/{id}")
	public ModelAndView modifierEnMod(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			Role roleAdmin = roleService.getRowByNom("ADMINISTRATEUR");
			// Il faut laisser au moins 1 administrateur
			if (uti.getRoleId()==roleAdmin.getId())
				if (utilisateurService.getListByRole(roleAdmin.getId()).size()<=1) {
					modelListeUtilisateurs.put("nbAdminInsuffisant", true);
					return getListeUtilisateurs(modelListeUtilisateurs);
				}
			uti.setRoleId(roleService.getRowByNom("MODERATEUR").getId());
			modelListeUtilisateurs.put("changementStatut", "mod�rateur");
			modelListeUtilisateurs.put("utilisateurSelectionne", uti.getMailLille1());
			utilisateurService.updateRow(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/modifierEnUti/{id}")
	public ModelAndView modifierEnUti(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			Role roleAdmin = roleService.getRowByNom("ADMINISTRATEUR");
			// Il faut laisser au moins 1 administrateur
			if (uti.getRoleId()==roleAdmin.getId())
				if (utilisateurService.getListByRole(roleAdmin.getId()).size()<=1) {
					modelListeUtilisateurs.put("nbAdminInsuffisant", true);
					return getListeUtilisateurs(modelListeUtilisateurs);
				}
			uti.setRoleId(roleService.getRowByNom("UTILISATEUR").getId());
			modelListeUtilisateurs.put("changementStatut", "utilisateur");
			modelListeUtilisateurs.put("utilisateurSelectionne", uti.getMailLille1());
			utilisateurService.updateRow(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/listCategories")
	public ModelAndView getListeCategories() {
			Map<String, Object> modelListeCategories = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			modelListeCategories.put("roleList", roleService.getList());
			modelListeCategories.put("utilisateur", utilisateurService.getUserInSession());
			modelListeCategories.put("catList", categorieService.getList());
			modelListeCategories.put("mapCategories", categorieService.getNbByCategorie());
//		}
		return new ModelAndView("admin_listeCategories", modelListeCategories);
	}
	
	@RequestMapping("/supprimerCategorie/{id}")
	public ModelAndView supprimerCategorie(@PathVariable("id") int idCategorie) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			
//		}
		return getListeCategories();
	}
}