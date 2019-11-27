package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.daos.POItemsDao;
import com.project.daos.PurchaseOrderDao;
import com.project.models.POItems;
import com.project.models.PurchaseOrder;

@Controller
public class SellerController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PurchaseOrderDao poObj;
	
	@RequestMapping(value = "/homeSeller", method = RequestMethod.GET)
	public String SellerPage(ModelMap map) {

		List<PurchaseOrder> polist = poObj.viewAllPo();
		map.addAttribute("polist", polist);
		session.setAttribute("polist", polist);
		return "SellerPage";
	}	
	
	@RequestMapping(value = "/viewPoList", method = RequestMethod.GET)
	public String viewPoList(ModelMap map) {

		List<PurchaseOrder> polist = poObj.viewAllPo();
		map.addAttribute("polist", polist);
		session.setAttribute("polist", polist);
		return "SellerViewPo";
	}	
	
	@Autowired
	POItemsDao	poitems;
	
	@RequestMapping(value = "/viewLineItems", method = RequestMethod.GET)
	public String viewLineItems(@RequestParam int viewId,ModelMap map) {
		System.out.println(viewId);
		List<POItems> poitemslist = poitems.getLineItemsById(viewId);
		map.addAttribute("poitemslist", poitemslist);
		System.out.println(poitemslist);
		session.setAttribute("poitemslist", poitemslist);
		return "SellerViewLineItems";
	}	
	
	@RequestMapping(value="/getSellerLogout",method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "HomePage";
      }
	
}
