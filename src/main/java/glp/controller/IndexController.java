package glp.controller;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Role;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.RoleService;
import glp.services.UtilisateurService;
import glp.util.IdBasicCategorie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping("/")
	public ModelAndView getIndex() {

		Map<String, Object> modelIndex = new HashMap<String, Object>();
		List<Categorie> listeCat = categorieService.getList();
		// get les annonces les plus récentes
		List<Annonce> annList = annonceService.getListRecent(categorieService.getIdByLib(IdBasicCategorie.ANNONCE)); 
		List<Annonce> covoitList = annonceService.getListRecent(categorieService.getIdByLib(IdBasicCategorie.COVOIT)); 
		modelIndex.put("covoitList", covoitList);
		modelIndex.put("annList", annList);
		modelIndex.put("roleList",  roleService.getList());
		modelIndex.put("utilisateur", utilisateurService.getUserInSession());
		modelIndex.put("catList", listeCat);


		return new ModelAndView("../index", modelIndex);
	}

//	public ModelAndView getIndex(HttpServletRequest request) {
//
//		List<Categorie> listeCat = categorieService.getList();
//		request.getSession().setAttribute("catList", listeCat);
//		return new ModelAndView("index");
//	}

}
