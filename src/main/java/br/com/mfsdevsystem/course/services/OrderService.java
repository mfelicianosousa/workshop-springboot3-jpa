package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.Order;
import br.com.mfsdevsystem.course.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}

}
