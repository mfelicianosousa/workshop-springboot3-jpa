package br.com.mfsdevsystem.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.repositories.UserRepository;
import br.com.mfsdevsystem.course.services.exceptions.DatabaseException;
import br.com.mfsdevsystem.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

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
		
	    try {
			
		   userRepository.deleteById( id );
		   		
		} catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException(id);
			
		} catch (DataIntegrityViolationException e) {
		
			throw new DatabaseException(e.getMessage());
		}
	}
	

	
	public User update(Long id, User user) {
		try {
			User entity = userRepository.getReferenceById( id );
			updateData(entity, user);
			return userRepository.save( entity );
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User user) {
	
		entity.setName( user.getName() );
		entity.setEmail( user.getEmail() );
		entity.setPhone( user.getPhone() );
		
	}
	
	
}
