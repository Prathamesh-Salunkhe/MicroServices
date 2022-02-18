package com.mouritech.feigndemo.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.feigndemo.productservice.Product;

@RestController
public class ProductController {
	
	private static List<Product> productList = new ArrayList<>();
	
	static {
		productList.add(new Product(1, "pen", 35));
		productList.add(new Product(2, "pencil", 25));
		productList.add(new Product(3, "NoteBook", 35));
		productList.add(new Product(4, "Eraser", 15));
		productList.add(new Product(5, "gel pen", 65));
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(productList);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int id){
		Product product = findProduct(id);
		if(product == null) {
			return ResponseEntity.badRequest().body("Invalid Product Id");
		}
		return ResponseEntity.ok(product);
		
	}

	private Product findProduct(int id) {

		return productList.stream()
				.filter(product -> product.getId().equals(id))
				.findFirst().orElse(null);
	}

}