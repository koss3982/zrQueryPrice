package com.croyan.queryprice.test;

import org.flywaydb.core.Flyway;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit5.FlywayTestExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Clase de test de integración para el servicio REST de QueryController.
 * Se realiza llamadas con diferentes parámetros de fecha hora
 * para comprobar que tanto el algoritmo de precios como los datos son correctos.
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@PropertySource("classpath:application-test.properties")
@TestPropertySource(
        locations = "classpath:application-test.properties")
@ExtendWith({SpringExtension.class})
@ExtendWith({FlywayTestExtension.class})
@FlywayTest
public class QueryControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void query_20200614_1000_price_35_50()
            throws Exception {


        mvc.perform(get("/query?date=2020-06-14T10:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['data']['currentPrice']").value(35.50));
    }

    @Test
    public void query_20200614_1600_price_25_45()
            throws Exception {


        mvc.perform(get("/query?date=2020-06-14T16:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['data']['currentPrice']").value(25.45));
    }

    @Test
    public void query_20200614_2100_price_35_50()
            throws Exception {


        mvc.perform(get("/query?date=2020-06-14T21:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['data']['currentPrice']").value(35.5));
    }

    @Test
    public void query_20200615_1000_price_30_50()
            throws Exception {


        mvc.perform(get("/query?date=2020-06-15T10:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['data']['currentPrice']").value(30.5));
    }

    @Test
    public void query_20200616_2100_price_38_95()
            throws Exception {


        mvc.perform(get("/query?date=2020-06-16T21:00&brandId=1&productId=35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['data']['currentPrice']").value(38.95));
    }
}