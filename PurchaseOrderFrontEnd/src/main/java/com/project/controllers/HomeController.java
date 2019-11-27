package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.daos.PurchaseOrderDao;
import com.project.daos.UserDao;
import com.project.models.PurchaseOrder;
import com.project.models.User;
import com.project.service.PurchaseOrderService;
import com.project.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	UserDao userService;
	
	@Autowired
	HttpSession session;
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	//===================HomePage========================
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homeController(ModelMap map ) {
	
		map.addAttribute("msg", "Welcome to Purchase Order");

	return "HomePage";

	}
	
	//==============================Register Page==========================
	
	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
	public ModelAndView registerUser(@Valid @ModelAttribute("userObj") User userObj, BindingResult result) {

			if (result.hasErrors()) {

				System.out.println(result.getAllErrors());

				ModelAndView mv = new ModelAndView("Register");
				mv.addObject("error", "User has not registered");
				return mv;
			}

			try {
				ModelAndView mv = new ModelAndView("Login");
				mv.addObject("login", new User());
				userService.registerUser(userObj);
				mv.addObject("msg", "User has been registered succesfully. Now u can Login");
				return mv;

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("error in registerUserDetailcontroller" + e.getMessage());
			}
			return null;

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
	
	@Autowired
	PurchaseOrderDao poObj;
	
	@RequestMapping(value="/signIn", method =RequestMethod.POST)
	public String validateUser(@RequestParam String userEmail ,@RequestParam String userPass,ModelMap map)
	{
		User uObj = userService.validateUser(userEmail, userPass);
		
		if(uObj==null)
		{
			return "RegisterForm";
		}
		else {
			session.setAttribute("uObj",uObj);
			if(uObj.getRole().equals("Buyer") && uObj.getIsActive().equals("Y"))
			{
			List<PurchaseOrder> obj = poObj.viewAllPo();
			map.addAttribute("poObj", obj);
			return "BuyerPage";
			
			}
			else if(uObj.getRole().equals("Vendor") && uObj.getIsActive().equals("Y")) {
				
				return "VendorPage";
			}
			
			else if(uObj.getRole().equals("Seller") && uObj.getIsActive().equals("Y")) {
				
				return "SellerPage";
			}
			return "Error Page";
		}
	}
	
	
	@RequestMapping(value="/homeBuyer",method=RequestMethod.GET)
	public String buyerHome(ModelMap map ) {
	return "BuyerPage";
	}
	
	@RequestMapping(value="/homeVendor",method=RequestMethod.GET)
	public String vendorHome(ModelMap map ) {
	return "VendorPage";
	}
	
}