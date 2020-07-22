package com.example.patterns2.facade.api;

import com.example.patterns2.facade.Order;
import com.example.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderFacade {

    @Autowired
    private ShopService shopService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder( OrderDto order, Long userId) throws OrderProcessingException {
        boolean isWrong = false;
        long orderId = shopService.openOrder(userId);
        LOGGER.info("Opening new order, ID: " + orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            isWrong = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem : order.getItems()) {
                LOGGER.info("Adding item: " + orderItem.getProductId() + ", " + orderItem.getQty() + " pcs");
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQty());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value equals: " + value + " USD");
            if (!shopService.processPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                isWrong = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for processed order");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                isWrong = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                isWrong = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order " + orderId + " submitted.");
        } finally {
            if (isWrong) {
                LOGGER.info("Cancelling order #" + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}
