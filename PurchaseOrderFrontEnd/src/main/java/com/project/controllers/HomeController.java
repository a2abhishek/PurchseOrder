package com.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.models.User;
import com.project.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	//===================HomePage========================
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homeController(ModelMap map ) {
	
		map.addAttribute("msg", "Welcome to Purchase Order");

	return "HomePage";

	}
	
	//==============================Register Page==========================
	
	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		map.addAttribute("userObj", new User());
		
		return "Register";
	}	
	
	//===============================Login Page=========================
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public String LoginUser(ModelMap map) {		
		return "Login";
	}	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUserDetail(@ModelAttribute("UserObj") User userObj) {

			
			ModelAndView mv = new ModelAndView("Login");
			
			
			userService.registerUser(userObj);
			mv.addObject("msg", "User has been registered succesfully. Now u can Login");
			return mv;
	}
	
	//============================Login Validations=============================	
	
	
	@RequestMapping(value="/signIn", method =RequestMethod.POST)
	public String validateUser(@RequestParam String email ,@RequestParam String password)
	{
		User uObj = userService.validateUser(email, password);
		session.setAttribute("uObj",uObj);
		if(uObj==null)
		{
			return "RegisterForm";
		}
		else {
			if(uObj.getRole().equals("Buyer") && uObj.getIsActive().equals("Y"))
			{
			
			return "BuyerPage";
			}
			else if(uObj.getRole().equals("Vendor") && uObj.getIsActive().equals("Y")) {
				
				return "VendorPage";
			}
			
			else if(uObj.getRole().equals("Sellor") && uObj.getIsActive().equals("Y"))
			{
				return "SellerPage";
			}
			return "Error Page";
		}
	}
}