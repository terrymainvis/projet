package glp.controller;

import glp.domain.Role;
import glp.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("new")
	public ModelAndView getCatForm(@ModelAttribute Role role) {
		return new ModelAndView("role_form");
	}
	
	@RequestMapping("/addRole")
	public ModelAndView addUser(@ModelAttribute("role") Role role) {
		roleService.insertRow(role);
		return new ModelAndView("redirect:/");
	}

}
