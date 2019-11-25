package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.daos.ProductDao;
import com.project.daos.PurchaseOrderDao;
import com.project.daos.UserDao;
import com.project.models.POItems;
import com.project.models.PurchaseOrder;
import com.project.models.User;


@Controller
public class PurchaseOrderController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderObj;
	/*
	@RequestMapping(value="/purchaseOrder",method=RequestMethod.POST)
	public ModelAndView raisePurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder purchaseOrder,ModelMap map  ) {
		System.out.println("i m here");
		ModelAndView mv=new ModelAndView("SellerSuccess") ;
		System.out.println("i am going to finish");
		mv.addObject("msg","po is raised");
		return null;
		
		
	}*/
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao buyerDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/RaisePo", method = RequestMethod.GET)
		public String viewAllProducts(ModelMap map) {
			
			map.addAttribute("productDetails", productDao.viewAllProducts());
		return "RaisePurchaseOrder";

	}
	
	@RequestMapping(value="/raisePo",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<POItems> purchaseOrderItemsList,ModelMap map) {
		User bObj=(User)session.getAttribute("userObj");
		
		PurchaseOrder po=new PurchaseOrder();
		po.setBuyerObj(bObj);
		po.setSellerObj(buyerDao.getSeller());


		
		for(POItems obj:purchaseOrderItemsList) {
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(po);
		}
		
		po.setPoItemsObj(purchaseOrderItemsList);
		
				
		System.out.println("Purchase Order : "+po);
		
		
		purchaseOrderObj.addPo(po);
		
		map.addAttribute("msg","Purchase Order has been raised succesfully...");
		return "success";
	}		
}
