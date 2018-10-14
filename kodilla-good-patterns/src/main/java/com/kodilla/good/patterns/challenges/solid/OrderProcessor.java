package com.kodilla.good.patterns.challenges.solid;

public class OrderProcessor {
    private InformationService informationService;
    private ProductOrderService productOrderService;
    private ProductRepositoryService productRepositoryService;

    public OrderProcessor(final InformationService informationService,
                          final ProductOrderService productOrderService,
                          final ProductRepositoryService productRepositoryService) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.productRepositoryService = productRepositoryService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isAvailableInStock = productOrderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());

        if (isAvailableInStock) {
            informationService.sendOrderConfirmation(orderRequest.getUser());
            productRepositoryService.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            informationService.sendOrderRejection(orderRequest.getUser());
            return new OrderDto(orderRequest.getUser(), true);
        }
    }
}
