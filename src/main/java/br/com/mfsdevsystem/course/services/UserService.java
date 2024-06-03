package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.repositories.UserRepository;
import br.com.mfsdevsystem.course.services.exceptions.ResourceNotFoundException;

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
		
		Optional<User> user = userRepository.findById( id );
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById( id );
	}
	
	public User update(Long id, User user) {
		User entity = userRepository.getReferenceById( id );
		updateData(entity, user);
		return userRepository.save( entity );
	}

	private void updateData(User entity, User user) {
	
		entity.setName( user.getName() );
		entity.setEmail( user.getEmail() );
		entity.setPhone( user.getPhone() );
		
	}
	
	
}
