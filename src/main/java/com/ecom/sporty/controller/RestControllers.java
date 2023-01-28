package com.ecom.sporty.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecom.sporty.model.ProductModel;
import com.ecom.sporty.service.ProductService;

@RestController
public class RestControllers {

	@Autowired
	private ProductService service;

	@PostMapping("/addProducts/{name}/{qty}/{price}")
	public String addProducts(@PathVariable("name") String name, @PathVariable("qty") Integer qty,
			@PathVariable("price") Double price) {
		// return service.saveProducts(products);
		ProductModel pr = new ProductModel();
		pr.setName(name);
		pr.setQty(qty);
		pr.setPrice(price);

		service.saveProduct(pr);
		return "Payment";
		

	}

	// sample code to return jsp
	// @RequestMapping("/Payment")
	// public ModelAndView adminlogin() {
	// 	ModelAndView mv = new ModelAndView("Payment");
	// 	return mv;
	// }

	@PostMapping("/addProducts")
	public List<ProductModel> addProducts(@RequestBody List<ProductModel> products) {
		return service.saveProducts(products);
	}

	@GetMapping("/products")
	public List<ProductModel> findAllProducts() {
		return service.getProducts();
	}

	@PutMapping("/update")
	public ProductModel updateProduct(@RequestBody ProductModel product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
