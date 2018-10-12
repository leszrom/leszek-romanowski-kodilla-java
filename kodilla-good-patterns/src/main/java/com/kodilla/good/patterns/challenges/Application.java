package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieveOrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ToolsOrderService(),
                new ToolsRepositoryService());
        orderProcessor.process(orderRequest);
    }
}
