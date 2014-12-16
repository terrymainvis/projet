package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Champ;
import glp.domain.TypeChampEnum;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.ChampService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/categorie")
public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private AnnonceService annonceService;
	
	@Autowired
	private ChampService champService;
	
	@RequestMapping("new")
	public ModelAndView getCatForm(@ModelAttribute Categorie cat) {
		return new ModelAndView("cat_form");
	}

	@RequestMapping("/addCat")
	public ModelAndView addCategorie(@ModelAttribute Categorie cat) {
		categorieService.insertRow(cat);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "newChamp", method=RequestMethod.GET)
	public ModelAndView getAnnForm(@ModelAttribute Champ champ) {
		List<Categorie> catlist = categorieService.getList();
		
		List<TypeChampEnum> typelist = new ArrayList<TypeChampEnum>();
		for(int i=0 ; i<TypeChampEnum.values().length ; i++)
			typelist.add(TypeChampEnum.values()[i]);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("catlist", catlist);
		myModel.put("typelist", typelist);
		
		return new ModelAndView("champ_form", myModel);
	}
	
	@RequestMapping("/addChamp")
	public ModelAndView addAnnonce(@ModelAttribute("champ") @Valid Champ champ) {
		champService.insertRow(champ);
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
	

	@RequestMapping("/annonceByCate")
	public ModelAndView getAnnonceListe(@PathVariable("cat_id") int cat_id)
	{
		List<Annonce> annList = annonceService.getListByCat(cat_id);
		return new ModelAndView("ann_list", "annList", annList);
		
	}
	
	
	@RequestMapping("annonceByMot")
	public ModelAndView getAnnListMot(@RequestParam String searchText  ) {
		List<Annonce> annList = annonceService.getListByMot(searchText);
		return new ModelAndView("ann_list", "annList", annList);
	}

}
