package com.example.patterns2.facade;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class ProductService {

    public BigDecimal getPrice(Long productId) {
        Random rg = new Random();
        return new BigDecimal(rg.nextInt(100000) / 100);
    }
}
