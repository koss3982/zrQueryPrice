package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;
import com.croyan.queryprice.model.Price;
import com.croyan.queryprice.repository.PriceRepository;
import com.croyan.queryprice.rest.controller.QueryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase de negocio para realizar la consulta de tarifa y precios.
 *
 * Esta es la implementación estándard que busca los precios en la BDD.
 *
 */
public class QueryPriceStandardBP implements QueryPriceBP {
    private static final Logger LOG = LoggerFactory.getLogger(QueryPriceStandardBP.class);
    private PriceRepository priceRepository;

    @Autowired
    public QueryPriceStandardBP(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public ProductPriceBean search(LocalDateTime date, int brandId, int productId) throws NoPriceFoundException {
        ProductPriceBean retProdPriceBean;
        Price selectedPrice;

        selectedPrice = priceRepository.getById(1L);

        if (selectedPrice == null) {
            LOG.warn("No se ha encontrado ningún precio para => date: " + date + ", brandId: " + brandId + ", productId: " + productId);
            throw new NoPriceFoundException(brandId, productId);
        }


        return new ProductPriceBean(1,1,1,
                LocalDateTime.now().minus(3, ChronoUnit.DAYS),
                LocalDateTime.now().plus(6, ChronoUnit.DAYS),
                29.99);
    }
}
