package com.example.patterns2.facade;

public class Item {
    private final Long productId;
    private final double qty;

    public Item(final Long productId, final double qty) {
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
