package glp.controller;

import glp.domain.Utilisateur;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/utilisateur")
public class MyController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@RequestMapping("/")
	public ModelAndView getIndex() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/new")
	public ModelAndView getAnnForm(@ModelAttribute Utilisateur uti) {
		return new ModelAndView("uti_form");
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute("utilisateur") Utilisateur uti) {
		utilisateurService.insertRow(uti);
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping("/updateMailUtilisateur")
	public void updateMailUser() {
		System.out.println("Ok je passe là");
	}


}
