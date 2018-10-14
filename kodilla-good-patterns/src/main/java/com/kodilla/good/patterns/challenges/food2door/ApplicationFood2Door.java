package com.kodilla.good.patterns.challenges.food2door;

public class ApplicationFood2Door {
    public static void main(String[] args) {
        DeliveryRequestRetriever deliveryRequestRetriever = new DeliveryRequestRetriever();
        DeliveryRequest deliveryRequest = deliveryRequestRetriever.retrieveDeliveryRequest();
        ProductDeliveryServiceImpl productDeliveryServiceImpl = new ProductDeliveryServiceImpl();
        DeliveryProcessor deliveryProcessor;

        switch (deliveryRequest.getSupplier().getCompanyName()) {
            case "Extra Food Shop":
                deliveryProcessor = new DeliveryProcessorExtraFoodShop(productDeliveryServiceImpl);
                break;
            case "Healthy Shop":
                deliveryProcessor = new DeliveryProcessorHealthyShop(productDeliveryServiceImpl);
                break;
            default:
                deliveryProcessor = new DeliveryProcessorGlutenFreeShop(productDeliveryServiceImpl);
                break;
        }
        DeliveryDto deliveryDto = deliveryProcessor.process(deliveryRequest);
    }

}
