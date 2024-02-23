package chillo.tech.avis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	// exclude = {SecurityAutoConfiguration.class}
public class AvisUtilisateursApplication {

	public static void main(String[] args) {

		SpringApplication.run(AvisUtilisateursApplication.class, args);
	}

}