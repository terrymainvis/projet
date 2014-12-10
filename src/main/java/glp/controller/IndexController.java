package glp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import glp.domain.Categorie;
import glp.services.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/")
public class IndexController {
	@Autowired
	private CategorieService categorieService ;
	@RequestMapping("")
	public ModelAndView getIndex(HttpServletRequest request) {
		
		List<Categorie> listeCat=categorieService.getList();
		request.getSession().setAttribute("catList", listeCat);
		return new ModelAndView("index");
	}
}
