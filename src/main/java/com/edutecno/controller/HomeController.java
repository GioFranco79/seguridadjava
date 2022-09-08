package com.edutecno.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.model.Show;
import com.edutecno.model.Users;
import com.edutecno.services.ShowService;
import com.edutecno.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private ShowService showService;
	@Autowired
	private UserService userService;	
	
	@GetMapping("/user")
	public ModelAndView home(HttpSession httpSession, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/home");
		String username = principal.getName();
		Users usuario = userService.findByUsername(username);
		modelAndView.addObject("shows", showService.findAll());
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("valores", httpSession.getAttribute("valores"));		
		return modelAndView;
	}
		
	@SuppressWarnings("unchecked")
	@PostMapping("/users")
	public RedirectView home(HttpSession httpSession,@ModelAttribute Show detalles) {			
		List<Show> valores = new ArrayList<Show>();		
		if (httpSession.getAttribute("valores") != null) {
			valores.addAll((List<Show>) httpSession.getAttribute("valores"));
		}			
		valores.add(detalles);
		httpSession.setAttribute("valores", valores);
		return new RedirectView("/user");
	}
	
	@GetMapping("/agregar")
	public ModelAndView crear() {
		ModelAndView model = new ModelAndView("user/new");
		model.addObject("show", new Show());		
		return model;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Show show, Principal principal) {
		String username = principal.getName();
		Users usuario = userService.findByUsername(username);
		show.setCreatorShow(usuario);
		showService.add(show);
		return new RedirectView("/user");
	}
	
	@GetMapping("/modificar")
	public ModelAndView modificar(@RequestParam("id") Long id) {
		ModelAndView model = new ModelAndView("user/edit");
		model.addObject("show", showService.findById(id).get());
		return model;
	}
	
	@PostMapping("/edita")
	public RedirectView edita(@ModelAttribute Show show, Principal principal) {
		String username = principal.getName();
		Users usuario = userService.findByUsername(username);		
		if (show.getAux() == usuario.getUserId()) {
			show.setCreatorShow(usuario);
			showService.update(show);			
			return new RedirectView("/user");
		}
		return new RedirectView("/recurso-prohibido");
	}
	
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam("id") Long id) {
		showService.delete(id);
		return new RedirectView("/user");		
	}
}
