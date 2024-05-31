package br.com.mfsdevsystem.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mfsdevsystem.course.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}