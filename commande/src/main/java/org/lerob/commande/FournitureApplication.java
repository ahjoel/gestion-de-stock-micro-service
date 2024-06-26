package org.lerob.commande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FournitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournitureApplication.class, args);
	}

}
