package br.com.mfsdevsystem.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.course.entities.Payment;
import br.com.mfsdevsystem.course.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	
	private PaymentService paymentService ;
	
	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}


	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){

		List<Payment> list = paymentService.findAll();
		
		return ResponseEntity.ok().body( list );
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		Payment obj = paymentService.findById( id );
		return ResponseEntity.ok().body(obj);
	}

}
