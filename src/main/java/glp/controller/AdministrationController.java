package glp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import glp.domain.Role;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.ChampService;
import glp.services.ForumService;
import glp.services.JobService;
import glp.services.RoleService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private ChampService champService;
	
	@RequestMapping("/list")
	public ModelAndView getListeUtilisateurs(Map<String, Object> modelListeUtilisateurs) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(modelListeUtilisateurs==null)
				modelListeUtilisateurs = new HashMap<String, Object>();
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			listeUtilisateur = utilisateurService.getList();
			modelListeUtilisateurs.put("listeUtilisateurs", listeUtilisateur);
			modelListeUtilisateurs.put("utilisateur", utilisateurService.getUserInSession());
			modelListeUtilisateurs.put("roleList", roleService.getList());
			modelListeUtilisateurs.put("catList", categorieService.getList());
			modelListeUtilisateurs.put("newUser", new Utilisateur());
			return new ModelAndView("admin_listeUtilisateurs", modelListeUtilisateurs);
//		}  else
//			return new ModelAndView("redirect:/");
	}
	
	/*
	 *  Changement statut en administrateur
	 */
	@RequestMapping("/modifierStatutAdmin/{id}")
	public ModelAndView modifierStatutAdmin(@PathVariable("id") int idUtilisateur) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutAdmin(uti);
			return getListeUtilisateurs(modelListeUtilisateurs);
//		}  else
//		return new ModelAndView("redirect:/");
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelModifierStatutAdmin(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
		// Il faut laisser au moins 1 administrateur
		if (utilisateurService.isAdministrateur(u)) {
			if (utilisateurService.getListByRole("ADMINISTRATEUR").size()<=1) {
				modelListeUtilisateurs.put("nbAdminInsuffisant", true);
				return modelListeUtilisateurs;
			}
			u.removeRole("ADMINISTRATEUR");
			modelListeUtilisateurs.put("changementStatut", "n'est plus ADMINISTRATEUR");
		} else {
			u.addRole(roleService.getRowByNom("ADMINISTRATEUR"));
			modelListeUtilisateurs.put("changementStatut", "devient ADMINISTRATEUR");
		}
		utilisateurService.updateRow(u);
		modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
		return modelListeUtilisateurs;
	}
	
	/*
	 *  Changement statut en moderateur
	 */
	@RequestMapping("/modifierStatutMod/{id}")
	public ModelAndView modifierStatutMod(@PathVariable("id") int idUtilisateur) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutMod(uti);
			return getListeUtilisateurs(modelListeUtilisateurs);
//		}  else
//		return new ModelAndView("redirect:/");
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelModifierStatutMod(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
		if(utilisateurService.isModerateur(u)) {
			u.removeRole("MODERATEUR");
			modelListeUtilisateurs.put("changementStatut", "n'est plus MODERATEUR");
		} else {
			u.addRole(roleService.getRowByNom("MODERATEUR"));
			modelListeUtilisateurs.put("changementStatut", "devient MODERATEUR");
		}
		modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
		utilisateurService.updateRow(u);
		return modelListeUtilisateurs;
	}
	
	/*
	 *  Changement statut en representant
	 */
	@RequestMapping("/modifierStatutRep/{id}")
	public ModelAndView modifierStatutRep(@PathVariable("id") int idUtilisateur) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutRep(uti);
			return getListeUtilisateurs(modelListeUtilisateurs);
//		}  else
//		return new ModelAndView("redirect:/");
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelModifierStatutRep(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(utilisateurService.isRepresentant(u)) {
				u.removeRole("REPRESENTANT");
				modelListeUtilisateurs.put("changementStatut", "n'est plus REPRESENTANT");
			} else {
				u.addRole(roleService.getRowByNom("REPRESENTANT"));
				modelListeUtilisateurs.put("changementStatut", "devient REPRESENTANT");
			}
			modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
			utilisateurService.updateRow(u);
//		}			
		return modelListeUtilisateurs;
	}
	
	@RequestMapping("/listCategories")
	public ModelAndView getListeCategories(Map<String, Object> modelListeCategories) {
		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(modelListeCategories==null)
				modelListeCategories = new HashMap<String, Object>();
			modelListeCategories.put("utilisateur", utilisateurService.getUserInSession());
			modelListeCategories.put("catList", categorieService.getList());
			modelListeCategories.put("mapCategories", categorieService.getNbByCategorie());
			return new ModelAndView("admin_listeCategories", modelListeCategories);
		} else
			return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/supprimer/categorie/{id}")
	public ModelAndView supprimerCategorie(@PathVariable("id") int idCategorie) {
		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeCategories = new HashMap<String, Object>();
			if(categorieService.getRowById(idCategorie)!=null) {
				modelListeCategories.put("categorieSupprimee", categorieService.getRowById(idCategorie).getLib());
//				if(categorieService.getNbByCategorie().get(idCategorie)==0) {
					annonceService.supprimerAnnoncesCategorie(idCategorie);
					champService.supprimerChampCategorie(idCategorie);
					categorieService.deleteRow(idCategorie);
					modelListeCategories.put("isCategorieSupprimee", true);
//				} else 
//					modelListeCategories.put("isCategorieSupprimee", false);
			}
			return getListeCategories(modelListeCategories);
		}  else
			return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/nouveauStatut")
	public ModelAndView changementStatut(@ModelAttribute("utilisateur") Utilisateur utilisateur, @RequestParam("roleSelected") Role roleSelected) {
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			if(!utilisateur.getMailLille1().trim().isEmpty()) {
				Utilisateur u=utilisateurService.getRowByMailLille1(utilisateur.getMailLille1());
				Role r=roleService.getRowByNom(roleSelected.getNom());
				if(r!=null) {
					if(u!=null) {
						switch(r.getNom()) {
						case "ADMINISTRATEUR":
							return getListeUtilisateurs(modelModifierStatutAdmin(u));
						case "MODERATEUR":
							return getListeUtilisateurs(modelModifierStatutMod(u));
						case "REPRESENTANT":
							return getListeUtilisateurs(modelModifierStatutRep(u));
						case "UTILISATEUR":
							return getListeUtilisateurs(modelSupprimerRolesUtilisateur(u));
						default:
							;  break;
						}
						
					} else {
						u = new Utilisateur();
						u.setMailLille1(utilisateur.getMailLille1());
						Role rUtilisateur = roleService.getRowByNom("UTILISATEUR");
						u.addRole(r);
						u.addRole(rUtilisateur);
						utilisateurService.insertRow(u);
						modelListeUtilisateurs.put("changementStatut", "devient "+r.getNom());
					}
					modelListeUtilisateurs.put("utilisateurSelectionne", utilisateur.getMailLille1());
				}
			}
		return getListeUtilisateurs(modelListeUtilisateurs);
//		}  else
//			return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/supprimer/utilisateur/{id}")
	public ModelAndView supprimerRolesUtilisateur(@PathVariable("id") int idUtilisateur) {
		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			Utilisateur u=utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelSupprimerRolesUtilisateur(u);
			return getListeUtilisateurs(modelListeUtilisateurs);
		}  else
			return new ModelAndView("redirect:/");
		
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelSupprimerRolesUtilisateur(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
			if(u!=null) {
				if (utilisateurService.isAdministrateur(u) &&
					utilisateurService.getListByRole("ADMINISTRATEUR").size()<=1) {
						modelListeUtilisateurs.put("nbAdminInsuffisant", true);
						return modelListeUtilisateurs;
				}
				if(annonceService.getListByUtilisateur(u).isEmpty() && forumService.getListByUtilisateur(u).isEmpty() && jobService.getListByUtilisateur(u).isEmpty()) {
					utilisateurService.deleteRow(u.getId());
					modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
					modelListeUtilisateurs.put("changementStatut", "est maintenant supprimé");
				} else {
					Role r=roleService.getRowByNom("UTILISATEUR");
					u.setRoles(r);
					utilisateurService.updateRow(u);
					modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
					modelListeUtilisateurs.put("changementStatut", "n'a plus de rôles spéciaux");
				}
			}
			return modelListeUtilisateurs;
	}
	
	
}