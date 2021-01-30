package org.imt.j2ee.microservices.Nourelayne.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    
       //Attention!!!! Server Port is: 8081


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.imt.j2ee.microservices.Nourelayne.controller", "org.imt.j2ee.microservices.Nourelayne.Model", "org.imt.j2ee.microservices.Nourelayne.DAO"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
