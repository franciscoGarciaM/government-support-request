package mx.gob.metepec.government_support_request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GovernmentSupportRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GovernmentSupportRequestApplication.class, args);
	}

	//Agrega el metodo para crear el bean de RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
