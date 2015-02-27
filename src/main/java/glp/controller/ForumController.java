package glp.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




import glp.domain.Categorie;
import glp.domain.Forum;
import glp.domain.Signalisation;
import glp.domain.Utilisateur;
import glp.services.CategorieService;
import glp.services.ForumService;
import glp.services.SignalisationService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private SignalisationService signalisationService;
	@Autowired
	private CategorieService categorieService;
	
	public ForumController(){
		
	}
	
	// Renvoie sur le formulaire de creation dune annonce 
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView getAnnForm(@ModelAttribute Forum forum){
		Utilisateur utilisateur = utilisateurService.getUserInSession();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("utilisateur", utilisateur);
		myModel.put("catList", categorieService.getList());
		//myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("forum_form", myModel);
	}
	
	@RequestMapping("/addForum")
	public ModelAndView addAnnonce(@ModelAttribute Forum forum ) {
		forum.setAuteur(utilisateurService.getUserInSession());
		forum.setDate_deb(new Date());
		forumService.insertRow(forum);
		return new ModelAndView("redirect:/");
		// return "ann_list";
	}
	@RequestMapping(value = "listRecent", method = RequestMethod.GET)
	public ModelAndView getForumListRecent() {
		List<Forum> forumListRecent = forumService.getListRecent();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("forumListRecent", forumListRecent);
		return new ModelAndView("forum_listRecent",myModel);	
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getForumList() {
		List<Forum> forumList = forumService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("forumList", forumList);
		myModel.put("catList", categorieService.getList());
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("forum_list",myModel);	
	}
	@RequestMapping("{id}")
	public ModelAndView getForum(@PathVariable("id") int idForumSelected) {
		Forum forum = forumService.getRowById(idForumSelected);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catList", categorieService.getList());
		myModel.put("forum", forum);
		return new ModelAndView("consult_forum", myModel);
	}
	
	@RequestMapping("/signalements/{id}")
	public ModelAndView getSignalements(@PathVariable("id") int idTemoignage){
		Forum forum = forumService.getRowById(idTemoignage);
		List<Signalisation> listSignalisations = signalisationService.getListSignalements(forum);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("forum", forum);
		myModel.put("catList", categorieService.getList());
		myModel.put("signalements", listSignalisations);
		return new ModelAndView("forum_signalements", myModel);
	}
	
	@RequestMapping("/supprimer/{id}")
	public ModelAndView deleteForum(@PathVariable("id") int idForumSelected,
			HttpServletRequest request){
		Forum forum = forumService.getRowById(idForumSelected);
		List<Signalisation> lesSignalisations = signalisationService.getListSignalements(forum);
		for (Signalisation signalement : lesSignalisations){
			signalisationService.deleteRow(signalement.getId());
		}
		forumService.deleteRow(idForumSelected);
		List<Forum> forumList = forumService.getList();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("forumList", forumList);
		return new ModelAndView("forum_list", myModel);
	}

}
