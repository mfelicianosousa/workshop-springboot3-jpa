package br.com.mfsdevsystem.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mfsdevsystem.course.entities.Category;
import br.com.mfsdevsystem.course.entities.Order;
import br.com.mfsdevsystem.course.entities.OrderItem;
import br.com.mfsdevsystem.course.entities.Payment;
import br.com.mfsdevsystem.course.entities.Product;
import br.com.mfsdevsystem.course.entities.User;
import br.com.mfsdevsystem.course.enums.OrderStatus;
import br.com.mfsdevsystem.course.repositories.CategoryRepository;
import br.com.mfsdevsystem.course.repositories.OrderItemRepository;
import br.com.mfsdevsystem.course.repositories.OrderRepository;
import br.com.mfsdevsystem.course.repositories.ProductRepository;
import br.com.mfsdevsystem.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		Category c4 = new Category(null, "Telefonia");
		
	
		
		Product p1 = new Product(null, "The Lord of the Rings","Lorem ipsum dolor site amet, consectetur",90.5,"" );
		Product p2 = new Product(null, "Smart Tv","Nulla eu impoerdiet purus. Maecenas ante",2190.0,"" );
		Product p3 = new Product(null, "MacBook Pro","Nam eleifend maximus tortor, at mollis",1250.5,"" );
		Product p4 = new Product(null, "Pc Gamer","Donec aliquet odio ac rhoncus curus",1200.5,"" );
		Product p5 = new Product(null, "Rails for Dummies","Cras fringilla convallis sem vel faucibus",190.99,"" );
	
		categoryRepository.saveAll( Arrays.asList(c1, c2, c3, c4));	
		productRepository.saveAll( Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll( Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null,"Maria Brown", "maria@gmail.com", "9888888888", "123456");
		User u2 = new User(null,"Alex Green", "alex@gmail.com", "97777777777", "123456");
		User u3 = new User(null,"Marcelino Sousa", "marcelino@gmail.com", "98141-3390", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-06-01T19:53:07Z"), OrderStatus.PAIND, u1);
		Order o2 = new Order(null, Instant.parse("2024-06-01T08:20:10Z"), OrderStatus.WAITING_PAYMENT , u2);
		Order o3 = new Order(null, Instant.parse("2024-06-01T10:53:01Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o4 = new Order(null, Instant.parse("2024-05-04T05:53:05Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o5 = new Order(null, Instant.parse("2024-05-04T06:53:04Z"), OrderStatus.WAITING_PAYMENT, u3);
		
		userRepository.saveAll( Arrays.asList(u1, u2, u3 ));	
		orderRepository.saveAll( Arrays.asList(o1, o2, o3, o4, o5 ));	
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		OrderItem oi5 = new OrderItem(o5, p4, 1, p4.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));
		
		// Salvando Pagamento
	    Payment pay1 = new Payment(null, Instant.parse("2024-06-01T21:53:07Z"), o1);
	    // Atualiza no pedido o Pagamento
	    o1.setPayment(pay1);
	    // Salva o Order novamente;
	    orderRepository.save(o1);
	    
	}
	
	
}
