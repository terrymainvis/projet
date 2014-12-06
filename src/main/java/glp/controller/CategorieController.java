package glp.controller;

import java.util.List;

import glp.domain.Categorie;
import glp.services.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/categorie")
public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	@RequestMapping("new")
	public ModelAndView getCatForm(@ModelAttribute Categorie cat) {
		return new ModelAndView("cat_form");
	}

	@RequestMapping("/addCat")
	public ModelAndView addCategorie(@ModelAttribute Categorie cat) {
		categorieService.insertRow(cat);
		return new ModelAndView("redirect:cat_list");
	}

	@RequestMapping("list")
	public ModelAndView getCatList() {
		List<Categorie> catList = categorieService.getList();
		return new ModelAndView("cat_list", "catList", catList);
	}

}
