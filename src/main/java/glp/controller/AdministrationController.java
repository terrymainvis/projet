package glp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import glp.domain.Role;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.ForumService;
import glp.services.JobService;
import glp.services.RoleService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administration")
public class AdministrationController {
	
	@Autowired
	private AnnonceService annonceService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ForumService forumService;
	
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
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			listeUtilisateur = utilisateurService.getList();
			modelListeUtilisateurs.put("listeUtilisateurs", listeUtilisateur);
			modelListeUtilisateurs.put("utilisateur", utilisateurService.getUserInSession());
			modelListeUtilisateurs.put("catList", categorieService.getList());
			modelListeUtilisateurs.put("newUser", new Utilisateur());
//		}
		return new ModelAndView("admin_listeUtilisateurs", modelListeUtilisateurs);
	}
	
	@RequestMapping("/modifierEnAdmin/{id}")
	public ModelAndView modifierEnAdmin(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			uti.setRole(roleService.getRowByNom("ADMINISTRATEUR"));
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
			// Il faut laisser au moins 1 administrateur
			if (uti.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR"))
				if (utilisateurService.getListByRole(uti.getRole().getId()).size()<=1) {
					modelListeUtilisateurs.put("nbAdminInsuffisant", true);
					return getListeUtilisateurs(modelListeUtilisateurs);
				}
			uti.setRole(roleService.getRowByNom("MODERATEUR"));
			modelListeUtilisateurs.put("changementStatut", "modérateur");
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
			// Il faut laisser au moins 1 administrateur
			if (uti.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR"))
				if (utilisateurService.getListByRole(uti.getRole().getId()).size()<=1) {
					modelListeUtilisateurs.put("nbAdminInsuffisant", true);
					return getListeUtilisateurs(modelListeUtilisateurs);
				}
			uti.setRole(roleService.getRowByNom("UTILISATEUR"));
			modelListeUtilisateurs.put("changementStatut", "utilisateur");
			modelListeUtilisateurs.put("utilisateurSelectionne", uti.getMailLille1());
			utilisateurService.updateRow(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/listCategories")
	public ModelAndView getListeCategories(Map<String, Object> modelListeCategories) {
		if(modelListeCategories==null)
			modelListeCategories = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			modelListeCategories.put("roleList", roleService.getList());
			modelListeCategories.put("utilisateur", utilisateurService.getUserInSession());
			modelListeCategories.put("catList", categorieService.getList());
			modelListeCategories.put("mapCategories", categorieService.getNbByCategorie());
//		}
		return new ModelAndView("admin_listeCategories", modelListeCategories);
	}
	
	@RequestMapping("/supprimer/categorie/{id}")
	public ModelAndView supprimerCategorie(@PathVariable("id") int idCategorie) {
		Map<String, Object> modelListeCategories = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(categorieService.getRowById(idCategorie)!=null) {
				modelListeCategories.put("categorieSupprimee", categorieService.getRowById(idCategorie).getLib());
				if(categorieService.getNbByCategorie().get(idCategorie)==0) {
					categorieService.deleteRow(idCategorie);
					modelListeCategories.put("isCategorieSupprimee", true);
				} else 
					modelListeCategories.put("isCategorieSupprimee", false);
			}
//		}
		return getListeCategories(modelListeCategories);
	}
	
	@RequestMapping("/nouveauStatut")
	public ModelAndView changementStatut(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(!utilisateur.getMailLille1().isEmpty()) {
				Utilisateur u=utilisateurService.getRowByMailLille1(utilisateur.getMailLille1());
				Role r=roleService.getRowByNom(utilisateur.getRole().getNom());
				if(u!=null) {
					System.out.println(!utilisateur.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR"));
					/*
					 * Si on veut changer le role d'un administrateur et qu'il n'en reste qu'un
					 */
					if (!utilisateur.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR") &&
						u.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR") &&
						utilisateurService.getListByRole(u.getRole().getId()).size()<=1) {
							modelListeUtilisateurs.put("nbAdminInsuffisant", true);
							return getListeUtilisateurs(modelListeUtilisateurs);
					} else if(utilisateur.getRole().getNom().equalsIgnoreCase("UTILISATEUR")) {
						annonceService.supprimerAnnoncesUtilisateur(u);
						/*
						 * org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: No Session found for current thread
						 */
//						jobService.supprimerJobUtilisateur(u);
//						forumService.supprimerForumUtilisateur(u);
						utilisateurService.deleteRow(u.getId());
						modelListeUtilisateurs.put("changementStatut", "supprimé");
					} else {
						u.setRole(r);
						utilisateurService.updateRow(u);
						modelListeUtilisateurs.put("changementStatut", utilisateur.getRole().getNom());
					}
				} else {
					if(!utilisateur.getRole().getNom().equalsIgnoreCase("UTILISATEUR")) {
						u = new Utilisateur();
						u.setMailLille1(utilisateur.getMailLille1());
						u.setRole(r);
						utilisateurService.insertRow(u);
						modelListeUtilisateurs.put("changementStatut", utilisateur.getRole().getNom());
					}
				}
				modelListeUtilisateurs.put("utilisateurSelectionne", utilisateur.getMailLille1());
			}
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/supprimer/utilisateur/{id}")
	public ModelAndView supprimerUtilisateur(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur u=utilisateurService.getRowById(idUtilisateur);
			if (u.getRole().getNom().equalsIgnoreCase("ADMINISTRATEUR") &&
					utilisateurService.getListByRole(u.getRole().getId()).size()<=1) {
						modelListeUtilisateurs.put("nbAdminInsuffisant", true);
						return getListeUtilisateurs(modelListeUtilisateurs);
			}
			annonceService.supprimerAnnoncesUtilisateur(u);
			/*
			 * org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: No Session found for current thread
			 */
//			jobService.supprimerJobUtilisateur(u);
//			forumService.supprimerForumUtilisateur(u);
			utilisateurService.deleteRow(idUtilisateur);
			modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
			modelListeUtilisateurs.put("changementStatut", "supprimé");
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
}