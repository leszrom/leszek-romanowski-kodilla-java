package com.kodilla.good.patterns.challenges.food2door;

public class DeliveryProcessorExtraFoodShop implements DeliveryProcessor {
    private ProductDeliveryServiceImpl productDeliveryServiceImpl;

    public DeliveryProcessorExtraFoodShop(final ProductDeliveryServiceImpl productDeliveryServiceImpl) {
        this.productDeliveryServiceImpl = productDeliveryServiceImpl;
    }

    @Override
    public DeliveryDto process(final DeliveryRequest deliveryRequest) {
        boolean isDeliveryPossible = productDeliveryServiceImpl.deliveryAnalysis(deliveryRequest.getDelivery());
        if (isDeliveryPossible) {
            System.out.println("Sending delivery confirmation to Customer.");
            System.out.println("Sending order to stock system.");
            System.out.println("Sending order to accounting system.");
        } else {
            System.out.println("Sending delivery rejection");
        }
        return new DeliveryDto(deliveryRequest.getCustomer(), deliveryRequest.getDelivery(), isDeliveryPossible);
    }
}
