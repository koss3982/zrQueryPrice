package com.croyan.queryprice.repository;

import com.croyan.queryprice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
