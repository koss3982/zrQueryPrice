package com.croyan.queryprice.rest.controller;

import com.croyan.queryprice.backend.QueryPriceBP;
import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;
import com.croyan.queryprice.rest.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Microservicio de consulta de precios de artículos.
 */
@RestController
@RequestMapping("query")
public class QueryController {
    private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    //@Qualifier("DummyQueryPriceStandardBP")
    @Qualifier("QueryPriceStandardBP")
    private QueryPriceBP queryPriceBP;

    /**
     * Devuelve el precio de un artículo para una fecha concreta.
     * @param date Fecha en la cual se quiere saber el precio (obligatorio). Se Espera formato ISO yyyy-MM-ddThh:mm
     * @param brandId ID de la marca (obligatorio).
     * @param  productId ID del producto (obligatorio).
     * @return Devuelve el identificador del artículo y el precio actual de éste.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<ServiceResponse> getPrice(
            @RequestParam(value="date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime date,
            @RequestParam(value="brandId") long brandId,
            @RequestParam(value="productId") long productId
        )
            throws NoPriceFoundException {
        ResponseEntity resp;
        ProductPriceBean productPrice = null;
        ServiceResponse.Builder<ProductPriceBean> responseBuilder = new ServiceResponse.Builder();

        LOG.debug("Llamada getPrice con los parámetros: " +
                "{date: " + date + ", brandId: " + brandId + ", productId: " + productId + "}");
        // Aquí la parte lógica de la llamada. Esta está delegada al BP correspondiente
        productPrice = queryPriceBP.search(brandId, productId, date);

        // Devuelve la respuesta.
        // Se utiliza siempre una clase de respuesta que envuelve los datos.
        // Esta clase de respuesta contiene si la operación ha ido bien o no.
        // Asumimos que ha ido bien, ya que sinó, hubiera saltado una excepción
        // de precio no encontrado, o un error genérico de BDD, etc.
        responseBuilder
                .responseIsOk(true)
                .message("ok")
                .data(productPrice);

        return ResponseEntity.ok().body(responseBuilder.build());
    }

}
