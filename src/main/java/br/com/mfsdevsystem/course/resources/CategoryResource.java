package br.com.mfsdevsystem.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.course.entities.Category;
import br.com.mfsdevsystem.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	
	private CategoryService categoryService ;
	
	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@GetMapping
	public ResponseEntity<List<Category>> findAll(){

		List<Category> list = categoryService.findAll();
		
		return ResponseEntity.ok().body( list );
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = categoryService.findById( id );
		return ResponseEntity.ok().body(obj);
	}

}
