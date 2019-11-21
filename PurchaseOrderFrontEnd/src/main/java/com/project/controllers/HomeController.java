package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.models.Buyer;
import com.project.services.BuyerService;


@Controller
public class HomeController {
	
	@Autowired
	BuyerService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homeController(ModelMap map ) {
	
		map.addAttribute("msg", "Welcome to Purchase Order");

	return "HomePage";

	}
	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		map.addAttribute("buyerObj", new Buyer());
		
		return "Register";
	}	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUserDetail(@ModelAttribute("buyerObj") Buyer buyerObj) {

			
			ModelAndView mv = new ModelAndView("Login");
			
			
			service.registerBuyer(buyerObj);
			mv.addObject("msg", "User has been registered succesfully. Now u can Login");
			return mv;
		}

	}