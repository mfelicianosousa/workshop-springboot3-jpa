package br.com.mfsdevsystem.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mfsdevsystem.course.entities.Order;
import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.repositories.OrderRepository;
import br.com.mfsdevsystem.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Maria Brown", "maria@gmail.com", "9888888888", "123456");
		User u2 = new User(null,"Alex Green", "alex@gmail.com", "97777777777", "123456");
		User u3 = new User(null,"Marcelino Sousa", "marcelino@gmail.com", "98141-3390", "123456");
		
		
		
		Order o1 = new Order(null, Instant.parse("2024-06-01T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-06-01T08:20:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-06-01T10:53:01Z"), u1);
		Order o4 = new Order(null, Instant.parse("2024-05-04T05:53:05Z"), u3);
		Order o5 = new Order(null, Instant.parse("2024-05-04T06:53:04Z"), u3);
		
		userRepository.saveAll( Arrays.asList(u1, u2, u3 ));	
		orderRepository.saveAll( Arrays.asList(o1, o2, o3, o4, o5 ));	
	}
	
	
}
