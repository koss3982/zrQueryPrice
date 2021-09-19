package com.croyan.queryprice.exception;

/**
 * Excepción que se lanza cuando no se ha encontrado ningún precio con los parámetros indicados
 */
public class NoPriceFoundException extends Exception {

    private Long brandId;
    private Long productId;

    public NoPriceFoundException(Long brandId, Long productId) {
        super("No se ha encontrado ningún precio para brandId: " + brandId +" y productId: " + productId);

        this.brandId = brandId;
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getProductId() {
        return productId;
    }
}
