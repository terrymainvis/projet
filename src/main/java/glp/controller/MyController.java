package glp.controller;


import glp.domain.Categorie;
import glp.services.CategorieService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class MyController {
	
	@Autowired
	CategorieService categorieService;
	
	@RequestMapping("form")
	public ModelAndView getForm(@ModelAttribute Categorie cat){
		return new ModelAndView("form");
	}
	
	@RequestMapping("/addCat")
	public ModelAndView addCategorie(@ModelAttribute Categorie cat){
		categorieService.insertRow(cat);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("list")
	public ModelAndView getList(){
		List<Categorie> catList = categorieService.getList();
		return new ModelAndView("list","catList", catList);
	}
	
	
	
	
	

}
