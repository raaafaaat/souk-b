package com.csf.souk.service;

import java.util.ArrayList;  
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csf.souk.repository.FruitRepository;
 
//defining the business logic  
@Service  
public class FruitService  
{  
	@Autowired  
	FruitRepository pR ;  
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Fruit> getAllProduct()   
	{  
		List<Fruit> products = new ArrayList<Fruit>();  
		pR.findAll().forEach(p-> products.add(p));  
		return products;  	
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Fruit getProductById(int id)   
	{  
		return pR.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Fruit p)   
	{  
		pR.save(p);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		pR.deleteById(id);  
	}  
}  
