package com.croyan.queryprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Clase principal que inicializa el microservicio con Spring Boot.
 *
 * Hemos configurado la inyección con el paquete base de "com.croyan.queryprice".
 *
 */
@SpringBootApplication
@Configuration
@ImportResource("classpath:beans.xml")
@PropertySource("classpath:application.properties")
@EntityScan(basePackages= {
        "com.croyan.queryprice.model"
})
@ComponentScan(basePackages = {
        "com.croyan.queryprice"
})
public class QueryPriceMsApp {
    public static void main(String[] args) {
        SpringApplication.run(QueryPriceMsApp.class, args);
    }
}
