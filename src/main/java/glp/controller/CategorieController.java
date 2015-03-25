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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	/**
	 * 
	 * @param cat
	 * @return le formulaire de creation de catégorie
	 */
	@RequestMapping("new")
	public ModelAndView getCatForm(@ModelAttribute("categorie") Categorie cat) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("typelist", TypeChampEnum.values());
		myModel.put("catList", categorieService.getList());
		return new ModelAndView("cat_form", myModel);
	}

	/**
	 * enregistre en base la catégorie et ses champs qui ont été complétés dans le formulaire
	 * @param cat
	 * @return
	 */
	@RequestMapping("/addCat")
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView addCategorie(@ModelAttribute("categorie") Categorie cat) {
		
		//supprime les champs déchets (champs null générés par le javascript)
		//et valide l'association
		ArrayList<Champ> champs_tmp = new ArrayList<Champ>();
		
		if(cat.getChamps()!=null) {
			for(Champ c : cat.getChamps()) {
				if(c.getNom()!=null) {
					c.setCat(cat);
					champs_tmp.add(c);
				}
			}
		}
		
		cat.setChamps(champs_tmp);
				
		//ajoute la catégorie
		categorieService.insertRow(cat);
		
		//ajoute les champs
		for(Champ c : cat.getChamps()) {
			champService.insertRow(c);
		}
		
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
