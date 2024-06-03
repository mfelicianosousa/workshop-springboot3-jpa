package br.com.mfsdevsystem.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.course.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
