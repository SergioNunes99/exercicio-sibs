package com.example.exercicio_sibs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ExercicioSibsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioSibsApplication.class, args);
	}

}
