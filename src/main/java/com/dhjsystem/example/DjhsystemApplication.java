package com.dhjsystem.example;

import java.util.ArrayList;

import com.dhjsystem.example.domain.Role;
import com.dhjsystem.example.domain.User;
import com.dhjsystem.example.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DjhsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DjhsystemApplication.class, args);
	}

	// 애플리케이션 초기화 코드 추가
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Josh Yoo", "josh", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "IU", "iu", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Hyoshin Park", "hyoshin", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Naul Yoo", "naul", "1234", new ArrayList<>()));

			
			userService.addRoleToUser("iu","ROLE_USER");
			userService.addRoleToUser("iu","ROLE_MANAGER");
			userService.addRoleToUser("hyoshin","ROLE_MANAGER");
			userService.addRoleToUser("naul","ROLE_ADMIN");
			userService.addRoleToUser("josh","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("josh","ROLE_ADMIN");
			userService.addRoleToUser("josh","ROLE_USER");
		};
	}

}
