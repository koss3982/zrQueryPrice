package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;

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

        public ProductPriceBean search(LocalDateTime date, int brandId, int productId) throws NoPriceFoundException {

            // Datos de ejemplo
            return new ProductPriceBean(1,1,1,
                    LocalDateTime.now().minus(3, ChronoUnit.DAYS),
                    LocalDateTime.now().plus(6, ChronoUnit.DAYS),
                    29.99);
        }
}
