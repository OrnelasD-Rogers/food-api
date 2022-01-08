package com.ornelas.foodapi;

import com.ornelas.foodapi.infraestructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

//Substitui o repositório base de SimpleJpaRepository para CustomJpaRepositoryImpl
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
@SpringBootApplication
public class FoodApiApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(FoodApiApplication.class, args);
	}

}
