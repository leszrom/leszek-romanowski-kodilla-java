package com.kodilla.good.patterns.challenges;

public interface InformationService {
    void sendOrderConfirmation(User user);

    void sendOrderRejection(User user);
}
