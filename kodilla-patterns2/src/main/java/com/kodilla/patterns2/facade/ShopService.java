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
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isPaid()) {
                return true;
            } else {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean());
                return theOrder.isPaid();
            }
        }
        return false;
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random();
            if (!theOrder.isVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isVerified()) {
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }
}
