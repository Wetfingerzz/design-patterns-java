package com.example.patterns2.facade.api;

public class ItemDto {

    private final Long productId;
    private final double qty;

    public ItemDto (final Long productId, double qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQty() {
        return qty;
    }
}
