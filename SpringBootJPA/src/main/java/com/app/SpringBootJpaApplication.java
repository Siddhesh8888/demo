package com.app;


import com.app.entities.Demo;
import com.app.entities.User;
import com.app.repository.DemoRepository;
import com.app.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);

		UserRepository repo = context.getBean(UserRepository.class);

		User user = new User(1,"siddhesh patil","pune","java programmer");
		//repo.save(user);
//		User user2 = new User();
//		user2.setName("pratik koli");
//		user2.setCity("pune");
//		user2.setStatus("java programmer");

//		System.out.println(repo.save(user2));
//		User user3 = new User();
//		user3.setName("sanket deshmukh");
//		user3.setCity("pune");
//		user3.setStatus("data governance");
//		List<User> list = List.of(user3);
//		repo.saveAll(list);

		System.out.println(repo.findAll());

//		Optional<User> optional = repo.findById(2);
//		System.out.println(optional.get());
//		repo.deleteById(52);
//		System.out.println("deleted");

		System.out.println(repo.findByName("Siddhesh patil"));
		System.out.println(repo.findByStatusOrderByIdDesc("java programmer"));

		List<User> list = repo.usersByCity("pune");
		list.forEach(u-> System.out.println(u));

		System.out.println("===============================================");
		repo.getUsers().forEach(u-> System.out.println(u));
		System.out.println("==============================================");
//		Demo demo = new Demo();
//		demo.setDate(LocalDate.now());
		
		DemoRepository demorepo= context.getBean(DemoRepository.class);
		Demo demo=demorepo.findById(1).orElseThrow();
//		demorepo.save(demo);
		System.out.println(demo);
		
		


	}

}
