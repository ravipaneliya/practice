package com.sportyshoes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportyshoes.model.Product;
import com.sportyshoes.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;

	public Product addProduct(Product prod) {
		return productRepo.save(prod);
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		if (productRepo.findById(id).isPresent())
			return productRepo.findById(id).get();
		else
			return null;
	}

	public Product updateProduct(Product prod, int id) {
		if (productRepo.findById(id).isPresent()) {
			Product old = productRepo.findById(id).get();
			old.setName(prod.getName());
			old.setDescription(prod.getDescription());
			old.setPrice(prod.getPrice());
			old.setCategory(prod.getCategory());
			return productRepo.save(old);
		} else
			return null;
	}
	
	public boolean deleteProduct(int id) {
		if (productRepo.findById(id).isPresent()) {
			productRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
