package com.croyan.queryprice.exception;

/**
 * Excepción que se lanza cuando no se ha encontrado ningún precio con los parámetros indicados
 */
public class NoPriceFoundException extends Exception {

    private int brandId;
    private int productId;

    public NoPriceFoundException(int brandId, int productId) {
        super("No se ha encontrado ningún precio para brandId: " + brandId +" y productId: " + productId);

        this.brandId = brandId;
        this.productId = productId;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getProductId() {
        return productId;
    }
}
