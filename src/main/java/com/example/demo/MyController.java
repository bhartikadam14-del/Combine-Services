package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MyController {
	@Autowired
	CombineServiceApplication csa;

	
@GetMapping("/{id}")
public Combineservice show(@PathVariable int id) {
 RestTemplate template=csa.getRestTemplate();
 Product p=template.getForObject("https://ciran12481.pythonanywhere.com/product/"+id, Product.class);
 Customer c=template.getForObject("https://springfirst-bicx.onrender.com/"+id, Customer.class);
 Combineservice cs=new Combineservice();
 cs.setProduct(p);
 cs.setCustomer(c);
 return cs;
}
}
