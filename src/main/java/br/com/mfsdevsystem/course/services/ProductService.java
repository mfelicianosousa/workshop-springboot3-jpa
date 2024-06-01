package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.Product;
import br.com.mfsdevsystem.course.repositories.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository; 

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById( id );
		return obj.get();
	}
	
	
}
