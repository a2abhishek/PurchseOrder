package com.project.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.daos.ProductDao;
import com.project.daos.PurchaseOrderDao;
import com.project.daos.UserDao;
import com.project.models.POItems;
import com.project.models.Products;
import com.project.models.PurchaseOrder;
import com.project.models.User;


@Controller
public class PurchaseOrderController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderObj;
	
	
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
	
	@RequestMapping(value = "/getProductNameById", method = RequestMethod.GET)
	@ResponseBody
	public Products getProductById(@RequestParam int productId, ModelMap map) {
	Products pObj =  productDao.getProductById(productId);
	return pObj;

}
	@ResponseBody
	@RequestMapping(value="/raisePO",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<POItems> purchaseOrderItemsList,ModelMap map) {
		System.out.println("Inside Purchase Order >>>");
		User bObj=(User)session.getAttribute("userObj");

		PurchaseOrder po=new PurchaseOrder();
		po.setCreatedDate(LocalDate.now());
		po.setStatus("send to seller");
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
		return " ";
	}		
}
