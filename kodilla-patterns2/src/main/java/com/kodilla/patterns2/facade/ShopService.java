package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    private Authenticator authenticator;
    private ProductService productService;

    @Autowired
    public ShopService(Authenticator authenticator, ProductService productService) {
        this.authenticator = authenticator;
        this.productService = productService;
    }

    public Long openOrder(Long userId) {
        Long orderId = -1L;
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrderId = orders.stream()
                    .map(Order::getOrderId)
                    .max(Long::compare)
                    .orElse(0L);
            orderId = maxOrderId + 1;
            orders.add(new Order(orderId, userId, productService));
        }
        return orderId;
    }

    public void addItem(Long orderId, Long productId, double quantity) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.getItems().add(new Item(productId, quantity)));
    }

    public boolean removeItem(Long orderId, Long productId) {
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(order -> order.getItems().stream()
                        .filter(item -> item.getProductId().equals(productId))
                        .findFirst()
                        .map(item -> order.getItems().remove(item))
                        .orElse(false))
                .orElse(false);
    }

    public BigDecimal calculateValue(Long orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(Order::calculateValue)
                .orElse(BigDecimal.ZERO);
    }

    public boolean doPayment(Long orderId) {
        Random generator = new Random();
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(order -> {
                    if (!order.isPaid()) {
                        order.setPaid(generator.nextBoolean());
                    }
                    return order.isPaid();
                })
                .orElse(false);
    }

    public boolean verifyOrder(Long orderId) {
        Random generator = new Random();
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(order -> {
                    if (!order.isVerified()) {
                        order.setVerified(order.isPaid() && generator.nextBoolean());
                    }
                    return order.isVerified();
                })
                .orElse(false);
    }

    public boolean submitOrder(Long orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(order -> {
                    if (order.isVerified()) {
                        order.setSubmitted(true);
                    }
                    return order.isSubmitted();
                })
                .orElse(false);
    }

    public void cancelOrder(Long orderId) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .map(orders::remove);
    }
}
