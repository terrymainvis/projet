package glp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import glp.domain.Annonce;
import glp.domain.Forum;
import glp.domain.Utilisateur;
import glp.services.ForumService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	public ForumController(){
		
	}
	
	// Renvoie sur le formulaire de creation dune annonce 
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView getAnnForm(@ModelAttribute Forum forum){
		Utilisateur utilisateur = utilisateurService.getUserInSession();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("utilisateur", utilisateur);
		myModel.put("utilisateur", utilisateurService.getUserInSession());
		return new ModelAndView("forum_form", myModel);
	}
	
	@RequestMapping("/addForum")
	public ModelAndView addAnnonce(@ModelAttribute Forum forum ) {
		forum.setAuteur(utilisateurService.getUserInSession());
		forumService.insertRow(forum);
		return new ModelAndView("redirect:/");
		// return "ann_list";
	}
	

}
