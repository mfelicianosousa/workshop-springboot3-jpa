package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.Category;
import br.com.mfsdevsystem.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository; 

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById( id );
		return obj.get();
	}
	
	
}
