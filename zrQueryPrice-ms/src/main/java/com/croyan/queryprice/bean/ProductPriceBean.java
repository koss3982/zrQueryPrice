package com.croyan.queryprice.bean;

import java.time.LocalDateTime;

public record ProductPriceBean
        (Long brandId, Long productId, Long priceId,
         LocalDateTime startDate, LocalDateTime endDate, double currentPrice) {
}
