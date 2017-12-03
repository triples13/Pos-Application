package org.shopping.task.pos.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.shopping.task.pos.model.Employee;
import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.model.Products;
import org.shopping.task.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("cartorders")
public class PosController {

	final static Logger logger=Logger.getLogger(PosController.class);
			
	@Autowired
	ProductService service;
	@RequestMapping(value="/getorder")
	public String getProduct(@RequestParam("bid") String bid,Model map){
		logger.info("start logging");
		Products product=service.listAll(bid);
		map.addAttribute("productlist",product);
		logger.error("error while saving object");
		System.out.println(product);
		return "index";
	}
	@RequestMapping(value="/addproduct",method = RequestMethod.POST)
	public @ResponseBody List<Order> addProducts(@RequestBody Order order,Model model){
		
		List<Order> orders=service.showOrder(order);
		model.addAttribute("cartorders", orders);
		return orders;
		}
	@RequestMapping(value="/confirmOrder",method=RequestMethod.GET)
	public String getConfirmOrder(Model map){
		return "confirm";
	}
	
	
	
	
}
