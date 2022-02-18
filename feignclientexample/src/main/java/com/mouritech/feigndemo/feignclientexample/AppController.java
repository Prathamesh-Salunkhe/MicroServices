package com.mouritech.feigndemo.feignclientexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AppController {
	
	@Autowired
	private ProductServiceClient productServiceClient;
	
	@GetMapping("/fetchproducts")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(productServiceClient.getAllProducts());
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int id){
		Product product = productServiceClient.getProduct(id);
		return ResponseEntity.ok(product);
	}
}