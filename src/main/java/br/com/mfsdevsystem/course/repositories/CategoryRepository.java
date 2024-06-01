package br.com.mfsdevsystem.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
