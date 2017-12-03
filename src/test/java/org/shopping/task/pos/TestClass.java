package org.shopping.task.pos;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.MockitoAnnotations;
import org.shopping.task.pos.controller.PosController;
import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class TestClass {

	 @Autowired
	 private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@Mock
	ProductService service;
	@InjectMocks
	PosController controller;
	
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc =  MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }
	
	@Test
	public void testGetResult() throws Exception{
		
		Order order=new Order();
		order.setBarcodeid("97");
		order.setPname("lyril");
		order.setPrice(456.00);
		order.setQty(1);
		Order order1=new Order();
		order1.setBarcodeid("97");
		order1.setPname("lyril");
		order1.setPrice(456.00);
		order1.setQty(4);
		Order order2=new Order();
		order2.setBarcodeid("146");
		order2.setPname("dove");
		order2.setPrice(123.00);
		order2.setQty(2);
		List<Order> orders=new ArrayList<Order>();
		when(controller.addProducts(order)).thenReturn(orders);
		 mockMvc.perform(get("/addproduct"))
         .andExpect(status().isOk())
         .andExpect(
                 content().contentType(MediaType.APPLICATION_JSON_VALUE));
         

	}
	
}
