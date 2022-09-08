package com.edutecno.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.model.Rating;
import com.edutecno.model.Users;
import com.edutecno.services.RatingService;
import com.edutecno.services.ShowService;
import com.edutecno.services.UserService;

@Controller
public class ShowController {
	@Autowired
	private ShowService showService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserService userService;
	
	private Long ShowId = (long) 0;
	
	@GetMapping("/rankear")
	public ModelAndView rankear(@RequestParam("id") Long id) {
		ModelAndView model = new ModelAndView("user/show");
		this.ShowId = id;
		model.addObject("show", showService.findById(id).get());
		model.addObject("ratings", ratingService.findAllShows(id));
		return model;
	}
	
	@PostMapping("/clasificar")
	public RedirectView clasificar(@ModelAttribute Rating rating, Principal principal) {
		String username = principal.getName();
		Users usuario = userService.findByUsername(username);		
		rating.setUser(usuario);
		rating.setShow(showService.findById(this.ShowId).get());
		ratingService.add(rating);
		return new RedirectView("/rankear?id=" + this.ShowId);
	}
}
