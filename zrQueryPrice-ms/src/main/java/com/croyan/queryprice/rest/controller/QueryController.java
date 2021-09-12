package com.croyan.queryprice.rest.controller;

import com.croyan.queryprice.backend.QueryPriceBP;
import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.rest.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Microservicio de consulta de precios de artículos.
 */
@RestController
@RequestMapping("query")
public class QueryController {
    private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    @Qualifier("DummyQueryPriceStandardBP")
    private QueryPriceBP queryPriceBP;

    /**
     * Devuelve el precio de un artículo para una fecha concreta.
     * @return Devuelve el identificador del artículo y el precio actual de éste.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<ProductPriceBean> getPrice() {
        ResponseEntity resp;
        ProductPriceBean productPrice = null;
        ServiceResponse.Builder<ProductPriceBean> responseBuilder = new ServiceResponse.Builder();

        try {
            LOG.debug("Llamada getPrice");
            // Aquí la parte lógica de la llamada. Esta está delegada al BP correspondiente
            productPrice = queryPriceBP.search(LocalDateTime.now(), 1, 1);

            // Devuelve la respuesta.
            // Se utiliza siempre una clase de respuesta que envuelve los datos.
            // Esta clase de respuesta contiene si la operación ha ido bien o no.
            responseBuilder.data(productPrice);
            responseBuilder.message("ok");
        }
        catch(Throwable ex) {
            LOG.error("Error no esperado al recuperar el precio del artículo", ex);

            // Para la demo puede quedarse con un catch-all.
            // No obstante es mejor capturar cada tipo de excepción en CATCH separados
            // y dejar un Throwable genérico al final para no dejar escapar ninguna excepción.
            responseBuilder.responseIsOk(false);
            // No se debe pasar la información interna/técnica hacia a fuera.
            // En todo caso, la cadena de error puede ser genérica y logear de forma interna el error real.
            responseBuilder.message("Error no esperado al obtener el precio del artículo");
            ResponseEntity.internalServerError().body(responseBuilder.build());
        }

        return ResponseEntity.ok().body(productPrice);
    }

}
