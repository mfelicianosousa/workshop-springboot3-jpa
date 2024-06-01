package br.com.mfsdevsystem.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
