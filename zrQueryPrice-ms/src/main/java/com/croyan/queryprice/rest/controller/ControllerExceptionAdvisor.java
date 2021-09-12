package com.croyan.queryprice.rest.controller;

import com.croyan.queryprice.exception.NoPriceFoundException;
import com.croyan.queryprice.rest.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Controlador general de gestión de excepciones.
 *
 */
@ControllerAdvice
public class ControllerExceptionAdvisor extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionAdvisor.class);

    @ExceptionHandler(NoPriceFoundException.class)
    public ResponseEntity<ServiceResponse> handleNoPriceFoundException(
            NoPriceFoundException ex, WebRequest request) {
        LOG.error("NoPriceFoundException: " + ex.getMessage(), ex);

        ServiceResponse.Builder<Object> responseBuilder = new ServiceResponse.Builder();
        responseBuilder.responseIsOk(false);
        responseBuilder.data("");
        responseBuilder.message("No se ha encontrado ningún precio para artículo => brandId: " + ex.getBrandId() + ", productId: " + ex.getProductId());

        return ResponseEntity.internalServerError().body(responseBuilder.build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceResponse> handleGenericException(
            Exception ex, WebRequest request) {
        LOG.error("Generic error: " + ex.getMessage(), ex);

        ServiceResponse.Builder<Object> responseBuilder = new ServiceResponse.Builder();
        responseBuilder.responseIsOk(false);
        responseBuilder.data("");
        // No se debe pasar la información interna/técnica hacia a fuera.
        // En todo caso, la cadena de error puede ser genérica y logear de forma interna el error real.
        responseBuilder.message("Error no esperado al procesar la request");

        return ResponseEntity.internalServerError().body(responseBuilder.build());
    }



}
