package br.com.fit.petsInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PetsInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsInfoApplication.class, args);
	}

}
