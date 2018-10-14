package com.kodilla.good.patterns.challenges.solid;

public interface InformationService {
    void sendOrderConfirmation(User user);

    void sendOrderRejection(User user);
}
