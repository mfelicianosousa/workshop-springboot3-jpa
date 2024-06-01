package br.com.mfsdevsystem.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	private UserService userService ;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}


	@GetMapping
	public ResponseEntity<List<User>> findAll(){

		List<User> list = userService.findAll();
		
		return ResponseEntity.ok().body( list );
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = userService.findById( id );
		return ResponseEntity.ok().body(obj);
	}

}
