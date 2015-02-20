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
	
	@RequestMapping("/list")
	public ModelAndView getListeUtilisateurs(Map<String, Object> modelListeUtilisateurs) {
		if(modelListeUtilisateurs==null)
			modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			listeUtilisateur = utilisateurService.getList();
			modelListeUtilisateurs.put("listeUtilisateurs", listeUtilisateur);
			modelListeUtilisateurs.put("utilisateur", utilisateurService.getUserInSession());
			modelListeUtilisateurs.put("roleList", roleService.getList());
			modelListeUtilisateurs.put("catList", categorieService.getList());
			modelListeUtilisateurs.put("newUser", new Utilisateur());
//		}
		return new ModelAndView("admin_listeUtilisateurs", modelListeUtilisateurs);
	}
	
	/*
	 *  Changement statut en administrateur
	 */
	@RequestMapping("/modifierStatutAdmin/{id}")
	public ModelAndView modifierStatutAdmin(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutAdmin(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelModifierStatutAdmin(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
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
//		}			
	return modelListeUtilisateurs;
	}
	
	/*
	 *  Changement statut en moderateur
	 */
	@RequestMapping("/modifierStatutMod/{id}")
	public ModelAndView modifierStatutMod(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutMod(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelModifierStatutMod(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(utilisateurService.isModerateur(u)) {
				u.removeRole("MODERATEUR");
				modelListeUtilisateurs.put("changementStatut", "n'est plus MODERATEUR");
			} else {
				u.addRole(roleService.getRowByNom("MODERATEUR"));
				modelListeUtilisateurs.put("changementStatut", "devient MODERATEUR");
			}
			modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
			utilisateurService.updateRow(u);
//		}			
	return modelListeUtilisateurs;
	}
	
	/*
	 *  Changement statut en representant
	 */
	@RequestMapping("/modifierStatutRep/{id}")
	public ModelAndView modifierStatutRep(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur uti = utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelModifierStatutRep(uti);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
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
		if(modelListeCategories==null)
			modelListeCategories = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			modelListeCategories.put("current_user", utilisateurService.getUserInSession());
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
	public ModelAndView changementStatut(@ModelAttribute("utilisateur") Utilisateur utilisateur, @RequestParam("roleSelected") Role roleSelected) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
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
							return getListeUtilisateurs(modelSupprimerUtilisateur(u));
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
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	@RequestMapping("/supprimer/utilisateur/{id}")
	public ModelAndView supprimerUtilisateur(@PathVariable("id") int idUtilisateur) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			Utilisateur u=utilisateurService.getRowById(idUtilisateur);
			modelListeUtilisateurs=modelSupprimerUtilisateur(u);
//		}
		return getListeUtilisateurs(modelListeUtilisateurs);
	}
	
	/*
	 * Model fourni par cette methode pour pouvoir l'utiliser dans plusieurs methodes et diminuer le nombre de requetes
	 */
	public Map<String, Object> modelSupprimerUtilisateur(Utilisateur u) {
		Map<String, Object> modelListeUtilisateurs = new HashMap<String, Object>();
//		if(utilisateurService.isAdministrateur(utilisateurService.getUserInSession())) {
			if(u!=null) {
				if (utilisateurService.isAdministrateur(u) &&
					utilisateurService.getListByRole("ADMINISTRATEUR").size()<=1) {
						modelListeUtilisateurs.put("nbAdminInsuffisant", true);
						return modelListeUtilisateurs;
				}
				annonceService.supprimerAnnoncesUtilisateur(u);
				/*
				 * org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: No Session found for current thread
				 */
//				jobService.supprimerJobUtilisateur(u);
//				forumService.supprimerForumUtilisateur(u);
				utilisateurService.deleteRow(u.getId());
				modelListeUtilisateurs.put("utilisateurSelectionne", u.getMailLille1());
				modelListeUtilisateurs.put("changementStatut", "est maintenant supprimé");
			}
//		}			
		return modelListeUtilisateurs;
	}
	
	@RequestMapping(value ="statistique", method = RequestMethod.GET)
	public ModelAndView afficheStatistique(){
		int nbUser = utilisateurService.nbUtilisateur();
		int nbAnnonceEnligne= annonceService.nbAnnonceEnLigne();
		 Map<String, Integer> annonceByCat = annonceService.getNbByCategorie();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("annonceByCat", annonceByCat);
		myModel.put("nbUser", nbUser);
		myModel.put("nbAnnonceEnligne", nbAnnonceEnligne);

		return new ModelAndView("statistique", myModel);
	}
}