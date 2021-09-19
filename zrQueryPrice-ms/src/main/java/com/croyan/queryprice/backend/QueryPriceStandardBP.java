package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;
import com.croyan.queryprice.model.Price;
import com.croyan.queryprice.repository.PriceRepository;
import com.croyan.queryprice.rest.controller.QueryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    public ProductPriceBean search(Long brandId, Long productId, LocalDateTime date) throws NoPriceFoundException {
        ProductPriceBean retProdPriceBean;
        Price selectedPrice;

        selectedPrice = null;

        List<Price> listPrices = priceRepository.findProductPrice(brandId, productId, date);

        if (listPrices!=null && listPrices.size() > 0) {
            selectedPrice = listPrices.get(0);
        } else {
            LOG.warn("No se ha encontrado ningún precio para => date: " + date + ", brandId: " + brandId + ", productId: " + productId);
            throw new NoPriceFoundException(brandId, productId);
        }

        return toProducPriceBean(selectedPrice);
    }

    private ProductPriceBean toProducPriceBean(Price selectedPrice) {
        ProductPriceBean ppb;

        ppb = new ProductPriceBean(
                selectedPrice.getBrand().getId(),
                selectedPrice.getProduct().getId(),
                selectedPrice.getId(),
                selectedPrice.getStartDate(),
                selectedPrice.getEndDate(),
                new BigDecimal(selectedPrice.getPrice()).setScale(2, RoundingMode.HALF_EVEN)
                );

        return ppb;
    }
}
