package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.Payment;
import br.com.mfsdevsystem.course.repositories.PaymentRepository;

@Service
public class PaymentService {

	private PaymentRepository paymentRepository; 

	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> obj = paymentRepository.findById( id );
		return obj.get();
	}
	
	
}
