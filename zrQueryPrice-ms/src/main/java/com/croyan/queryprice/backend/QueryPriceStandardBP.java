package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase de negocio para realizar la consulta de tarifa y precios.
 *
 * Esta es la implementación estándard que busca los precios en la BDD.
 *
 */
public class QueryPriceStandardBP implements QueryPriceBP {

    public ProductPriceBean search(LocalDateTime date, int brandId, int productId) {

        return new ProductPriceBean(1,1,1,
                LocalDateTime.now().minus(3, ChronoUnit.DAYS),
                LocalDateTime.now().plus(6, ChronoUnit.DAYS),
                29.99);
    }
}
