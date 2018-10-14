package com.kodilla.good.patterns.challenges.food2door;

public class DeliveryProcessorHealthyShop implements DeliveryProcessor {
    private ProductDeliveryServiceImpl productDeliveryServiceImpl;

    public DeliveryProcessorHealthyShop(final ProductDeliveryServiceImpl productDeliveryServiceImpl) {
        this.productDeliveryServiceImpl = productDeliveryServiceImpl;
    }

    @Override
    public DeliveryDto process(final DeliveryRequest deliveryRequest) {
        boolean isDeliveryPossible = productDeliveryServiceImpl.deliveryAnalysis(deliveryRequest.getDelivery());
        if (isDeliveryPossible) {
            System.out.println("Sending delivery confirmation to Customer.");
            System.out.println("Sending email with order to storekeeper.");
            System.out.println("Sending order to accounting system.");
        } else {
            System.out.println("Sending delivery rejection");
        }
        return new DeliveryDto(deliveryRequest.getCustomer(), deliveryRequest.getDelivery(), isDeliveryPossible);
    }
}
