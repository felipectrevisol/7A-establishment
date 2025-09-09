package br.com.sev7aura.establishment;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAsync
@SpringBootApplication 
public class EstablishmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstablishmentApplication.class, args);
	}
}