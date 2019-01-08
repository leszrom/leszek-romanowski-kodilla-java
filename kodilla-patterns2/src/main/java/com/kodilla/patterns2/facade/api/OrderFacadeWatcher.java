package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" + "&& args(orderDto,userId)")
    public void logEvent(OrderDto orderDto, Long userId) {
        LOGGER.info("Processing order for userId: " + userId);
        LOGGER.info("Number of items: " + orderDto.getItems().size());
    }

    @AfterThrowing(pointcut = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing = "ex")
    public void afterException(OrderProcessingException ex) {
        LOGGER.info(ex.getMessage());
    }


}
