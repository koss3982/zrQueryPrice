package com.croyan.queryprice.bean;

import java.time.LocalDateTime;

public record ProductPriceBean
        (int brandId, int productId, int priceId,
         LocalDateTime startDate, LocalDateTime endDate, double currentPrice) {
}
