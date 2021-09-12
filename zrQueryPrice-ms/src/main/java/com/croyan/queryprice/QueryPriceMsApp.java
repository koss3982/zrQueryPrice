package com.croyan.queryprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal que inicializa el microservicio con Spring Boot.
 *
 * Hemos configurado la inyección con el paquete base de "com.croyan.queryprice".
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.croyan.queryprice"
})
public class QueryPriceMsApp {
    public static void main(String[] args) {
        SpringApplication.run(QueryPriceMsApp.class, args);
    }
}
