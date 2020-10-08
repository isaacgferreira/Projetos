package com.crud.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAa");
		System.out.println(new BCryptPasswordEncoder().encode("root"));
	}

}
