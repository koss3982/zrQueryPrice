package com.croyan.queryprice.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Record que actua como bean para devolver los datos por JSON en el microservicio REST.
 */
public record ProductPriceBean
        (Long brandId, Long productId, Long priceId,
         LocalDateTime startDate, LocalDateTime endDate, BigDecimal currentPrice) {
}
