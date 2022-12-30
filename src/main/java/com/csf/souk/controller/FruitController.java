package com.csf.souk.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;

import com.csf.souk.model.Product;
import com.csf.souk.services.ProductServices;

//mark class as Controller  
@RestController  
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController  
{  
	//autowire the BooksService class  
	@Autowired  
	ProductServices pS;  
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/product")  
	private List<Product> getAllProduct()   
	{  
		return pS.getAllProduct();  
	}  
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/product/{id}")  
	private Product getProductById(@PathVariable("id") int id)   
	{  
		return pS.getProductById(id);  
	}  
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/product/{id}")  
	private void deleteProduct(@PathVariable("id") int id)   
	{  
		System.out.println("Suppression Product ID : " + id);
		pS.delete(id);  
	}  
	//creating post mapping that post the book detail in the database  
	@PostMapping("/product")  
	private int saveProduct(@RequestBody Product p)   
	{  
		pS.saveOrUpdate(p);  
		return p.getId();  
	}  
	//creating put mapping that updates the book detail   
	@PutMapping("/product")  
	private Product update(@RequestBody Product p)   
	{  
		pS.saveOrUpdate(p);  
		return p;  
	}  
} 

