package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@EnableAspectJAutoProxy
@Service
public class OrderFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);
    private ShopService shopService;

    @Autowired
    public OrderFacade(ShopService shopService) {
        this.shopService = shopService;
    }

    public void processOrder(final OrderDto orderDto, final Long userId) throws OrderProcessingException {

            LOGGER.info("Registering new order..");
            long orderId = shopService.openOrder(userId);
            LOGGER.info("Registered new order, ID: " + orderId);

            for (ItemDto itemDto : orderDto.getItems()) {
                LOGGER.info("Adding item " + itemDto.getProductId() + ", " + itemDto.getQuantity() + " pcs");
                shopService.addItem(orderId, itemDto.getProductId(), itemDto.getQuantity());
            }

            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is " + value + " USD");

            if (!shopService.doPayment(orderId)) {
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order " + orderId + " submitted");
    }
}
