package com.croyan.queryprice.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductPriceBean
        (Long brandId, Long productId, Long priceId,
         LocalDateTime startDate, LocalDateTime endDate, BigDecimal currentPrice) {
}
