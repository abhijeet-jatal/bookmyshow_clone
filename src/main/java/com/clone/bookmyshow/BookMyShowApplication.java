package com.clone.bookmyshow;

import com.clone.bookmyshow.controllerrs.UserController;
import com.clone.bookmyshow.dtos.SignUpRequestDTO;
import com.clone.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Gives info about createdOn, LastModifiedAt
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder().
				email("abhijeet@test.com")
				.password("1234").build();
		SignUpResponseDTO responseDTO = userController.signUp(signUpRequestDTO);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);

	}
}