package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository; 

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById( id );
		return obj.get();
	}
	
	
}
