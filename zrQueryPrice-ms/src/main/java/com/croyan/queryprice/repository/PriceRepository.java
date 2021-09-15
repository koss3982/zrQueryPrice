package com.croyan.queryprice.repository;

import com.croyan.queryprice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price,Long> {

    @Query("SELECT m FROM Price m " +
            "WHERE " +
            "m.brand.id=?1 AND " +
            "m.product.id=?2 AND " +
            "m.startDate <= ?3 AND " +
            "m.endDate >= ?3 " +
            "ORDER BY m.priority DESC")
    List<Price> findProductPrice(Long brandId, Long productId, LocalDateTime date);
}
