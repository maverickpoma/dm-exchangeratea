package com.maverick.dmexchangeratea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.maverick.dmexchangeratea.repository")
@EntityScan(basePackages = "com.maverick.dmexchangeratea.model")
public class DmExchangerateaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmExchangerateaApplication.class, args);
	}

}
