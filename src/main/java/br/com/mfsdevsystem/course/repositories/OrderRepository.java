package br.com.mfsdevsystem.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
