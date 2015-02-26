package glp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import glp.domain.Forum;
import glp.domain.Signalisation;
import glp.domain.Utilisateur;
import glp.services.ForumService;
import glp.services.SignalisationService;
import glp.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/signalisation")
public class SignalisationController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private SignalisationService signalService;
	@Autowired
	private UtilisateurService utilisateurService;
	
	public SignalisationController(){
		
	}
//	@RequestMapping(value = "new" , method = RequestMethod.GET)
//	public ModelAndView getsignalForm(@ModelAttribute Signalisation signal){
//		List<Forum> listForum = forumService.getList();
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("signal", signal);
//		myModel.put("listForum", listForum);
//		return new ModelAndView("signal_form", myModel);
//	}
	
	@RequestMapping("newModal/{id}")//@ModelAttribute Signalisation signal
	public ModelAndView getsignalForm(@PathVariable("id") int id,HttpServletRequest request){
		System.out.println("idididdidididdididididididid"+id);
		String motif = request.getParameter("motif");
		Forum forum = forumService.getRowById(id);
		Signalisation signal = new Signalisation(motif, forum);
		//signal.setForum(forum);
		//System.out.println(signal.getforum().getId());
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("signal", signal);
//		myModel.put("forum", forum);
		signalService.insertRow(signal);
		forum.setSignalements(forum.getSignalements() + 1);
		forumService.updateRow(forum);
		return new ModelAndView("redirect:/forum/"+id+"?estSignalee=true");
	}
	//pour signal sans modal
	@RequestMapping("new/{id}")//@ModelAttribute Signalisation signal
	public ModelAndView getsignalForm(@PathVariable("id") int id){
		System.out.println("idididdidididdididididididid"+id);
		Forum forum = forumService.getRowById(id);
		//signal.setForum(forum);
		//System.out.println(signal.getforum().getId());
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("signal", new Signalisation());
		myModel.put("forum", forum);
		return new ModelAndView("signal_form", myModel);
	}
	
//	@RequestMapping(value="/addSignal")
//	public ModelAndView addJob(Model model ,@RequestParam String desc){
//		Signalisation signal = new Signalisation(desc);
//		signal.setForum(new Forum());
//		signalService.insertRow(signal);
//		return new ModelAndView("redirect:/");
//	}
	@RequestMapping("/addSignal/{id}")
	public ModelAndView addSignal(@ModelAttribute Signalisation signal,@PathVariable("id") int id){
		Forum forum = forumService.getRowById(id);
		signal.setForum(forum);
		System.out.println(signal.getforum().getId());
		signalService.insertRow(signal);
		forum.setSignalements(forum.getSignalements() + 1);
		forumService.updateRow(forum);
		return new ModelAndView("redirect:/");
	}

}
