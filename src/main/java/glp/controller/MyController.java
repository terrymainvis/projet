package glp.controller;


import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.services.AnnonceService;
import glp.services.CategorieService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class MyController {
	 
	@Autowired
	CategorieService categorieService;
	@Autowired
	AnnonceService annonceService;
	
	@RequestMapping("cat_form")
	public ModelAndView getCatForm(@ModelAttribute Categorie cat){
		return new ModelAndView("cat_form");
	}
	
	@RequestMapping("/addCat")
	public ModelAndView addCategorie(@ModelAttribute Categorie cat){
		categorieService.insertRow(cat);
		return new ModelAndView("redirect:cat_list");
	}
	
	@RequestMapping("cat_list")
	public ModelAndView getCatList(){
		List<Categorie> catList = categorieService.getList();
		return new ModelAndView("cat_list","catList", catList);
	}
	
	@RequestMapping("ann_form")
	public ModelAndView getAnnForm(@ModelAttribute Annonce ann){
		List<Categorie> catList = categorieService.getList();
		return new ModelAndView("ann_form","catList", catList);
	}
	
	@RequestMapping("/addAnn")
	public ModelAndView addAnnonce(@ModelAttribute("annonce") @Valid Annonce ann){
		annonceService.insertRow(ann);
		return new ModelAndView("redirect:ann_list");
	}

	@RequestMapping("ann_list")
	public ModelAndView getAnnList(){
		List<Annonce> annList = annonceService.getList();
		return new ModelAndView("ann_list","annList", annList);
	}
	

}
