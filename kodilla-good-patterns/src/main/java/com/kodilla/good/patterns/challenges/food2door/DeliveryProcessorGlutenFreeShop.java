package com.kodilla.good.patterns.challenges.food2door;

public class DeliveryProcessorGlutenFreeShop implements DeliveryProcessor {
    private ProductDeliveryServiceImpl productDeliveryServiceImpl;

    public DeliveryProcessorGlutenFreeShop(final ProductDeliveryServiceImpl productDeliveryServiceImpl) {
        this.productDeliveryServiceImpl = productDeliveryServiceImpl;
    }

    @Override
    public DeliveryDto process(final DeliveryRequest deliveryRequest) {
        boolean isDeliveryPossible = productDeliveryServiceImpl.deliveryAnalysis(deliveryRequest.getDelivery());
        if (isDeliveryPossible) {
            System.out.println("Sending delivery confirmation to Customer.");
            System.out.println("Sending email with order details to storekeeper.");
            System.out.println("Sending email with order details to accountant.");
        } else {
            System.out.println("Sending delivery rejection");
        }
        return new DeliveryDto(deliveryRequest.getCustomer(), deliveryRequest.getDelivery(), isDeliveryPossible);
    }
}
