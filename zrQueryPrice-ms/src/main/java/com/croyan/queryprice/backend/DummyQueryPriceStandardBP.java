package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Implementación dummy de negocio para realizar la consulta de tarifa y precios.
 *
 * Esta implementación devuelve siempre los mismos datos ya que no se conecta a ninguna BDD.
 * Útil para realizar un test rápido de comunicación del microservicio.
 *
 */
public class DummyQueryPriceStandardBP implements QueryPriceBP {

        public ProductPriceBean search(Long brandId, Long productId, LocalDateTime date) throws NoPriceFoundException {

            // Datos de ejemplo
            return new ProductPriceBean(1L,1L,1L,
                    LocalDateTime.now().minus(3, ChronoUnit.DAYS),
                    LocalDateTime.now().plus(6, ChronoUnit.DAYS),
                    new BigDecimal(29.99).setScale(2, RoundingMode.HALF_EVEN)
                    );
        }
}
