package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.services.AnnonceService;
import glp.services.CategorieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired
	private CategorieService categorieService;

	@Autowired
	private AnnonceService annonceService;

	@RequestMapping("/ok")
	public ModelAndView getIndex() {
		System.out.println("test");
		Map<String, Object> modelIndex = new HashMap<String, Object>();
		List<Categorie> listeCat = categorieService.getList();
		List<Annonce> annList = annonceService.getListOfLastTen(); // get 10
																	// dernières
																	// annonces
		modelIndex.put("annList", annList);
		modelIndex.put("catList", listeCat);

		return new ModelAndView("redirect:/", modelIndex);
	}

//	public ModelAndView getIndex(HttpServletRequest request) {
//
//		List<Categorie> listeCat = categorieService.getList();
//		request.getSession().setAttribute("catList", listeCat);
//		return new ModelAndView("index");
//	}

}
