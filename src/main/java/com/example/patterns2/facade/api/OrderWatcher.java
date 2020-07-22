package com.example.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.example.patterns2.facade.api.OrderFacade.processOrder(..))"
            + "&&args (order, userId) && target (object)")
    public void logEvent(OrderDto order, long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + order.getClass().getName() + ", " + userId);
    }
}
