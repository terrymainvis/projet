package glp.controller;

import java.util.List;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.services.AnnonceService;
import glp.services.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/categorie")
public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private AnnonceService annonceService;
	
	@RequestMapping("new")
	public ModelAndView getCatForm(@ModelAttribute Categorie cat) {
		return new ModelAndView("cat_form");
	}

	@RequestMapping("/addCat")
	public ModelAndView addCategorie(@ModelAttribute Categorie cat) {
		categorieService.insertRow(cat);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("list")
	public ModelAndView getCatList() {
		List<Categorie> catList = categorieService.getList();
		return new ModelAndView("cat_list", "catList", catList);
	}
	
	
	@RequestMapping("annonceByCat")
	public ModelAndView getAnnList(@RequestParam int idCatSelect  ) {
		List<Annonce> annList = annonceService.getListByCat(idCatSelect);
		return new ModelAndView("ann_list", "annList", annList);
	}
	
	@RequestMapping("annonceByMot")
	public ModelAndView getAnnListMot(@RequestParam String searchText  ) { 
		List<Annonce> annList = annonceService.getListByMot(searchText);
		return new ModelAndView("ann_list", "annList", annList);
	}
	

	
	
	

}
