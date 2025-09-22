package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/combine/{id}")
    public Combineservice show(@PathVariable int id) {
        // Call external Product service
        Product p = restTemplate.getForObject(
            "https://ciran12481.pythonanywhere.com/product/" + id,
            Product.class
        );

        // Call external Customer service
        Customer c = restTemplate.getForObject(
            "https://springfirst-bicx.onrender.com/" + id,
            Customer.class
        );

        // Combine both into a single response
        Combineservice cs = new Combineservice();
        cs.setProduct(p);
        cs.setCustomer(c);

        return cs;
    }
}
