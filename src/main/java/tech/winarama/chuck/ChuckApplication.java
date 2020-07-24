package tech.winarama.chuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ChuckApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuckApplication.class, args);
	}
}
