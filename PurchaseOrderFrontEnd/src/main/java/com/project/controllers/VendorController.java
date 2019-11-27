package com.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.daos.UserDao;
import com.project.service.UserService;

@Controller
public class VendorController {

	@Autowired
	UserDao userService;
	
	@Autowired
	HttpSession session;
	
	//===================HomePage========================
	
	@RequestMapping(value="/vendorProductForm",method=RequestMethod.GET)
	public String addVendorProduct(ModelMap map ) {
	
		map.addAttribute("msg", "Add Products to vendor products table");

	return "VendorProductForm";

	}
	
	@RequestMapping(value="/viewVendorProduct",method=RequestMethod.GET)
	public String viewVendorProduct(ModelMap map ) {
	
		map.addAttribute("msg", "Welcome to Purchase Order");

	return "ViewVendorProducts";

	}
	@RequestMapping(value="/getVendorLogout",method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "HomePage";
      }

}
