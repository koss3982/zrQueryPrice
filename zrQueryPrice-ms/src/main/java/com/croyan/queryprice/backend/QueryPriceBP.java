package com.croyan.queryprice.backend;

import com.croyan.queryprice.bean.ProductPriceBean;
import com.croyan.queryprice.exception.NoPriceFoundException;

import java.time.LocalDateTime;

/**
 * Interficie de negocio para realizar la consulta de tarifa y precios.
 *
 * Se ha desarrollado una interficie en caso de que  puedan existir implementaciones especiales.
 * Por ejemplo: descuentos adicionales en tiendas de reciente apertura, épocas navideñas, etc.,
 * los cuales no estén reflejados en la base de datos, sino en reglas de negocio.
 */
public interface QueryPriceBP {
    public ProductPriceBean search(LocalDateTime date, int brandId, int productId) throws NoPriceFoundException;
}
