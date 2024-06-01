package br.com.mfsdevsystem.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.course.entities.User;

public interface ProdutoRepository extends JpaRepository<User, Long>{

}
