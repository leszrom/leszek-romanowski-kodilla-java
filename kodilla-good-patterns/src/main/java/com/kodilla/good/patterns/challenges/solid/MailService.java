package com.kodilla.good.patterns.challenges.solid;

public class MailService implements InformationService {
    @Override
    public void sendOrderConfirmation(User user) {
        System.out.print("Sending e-mail with order confirmation to User... ");
        System.out.println(user.getEmail());
        System.out.println();
    }
    @Override
    public void sendOrderRejection(User user) {
        System.out.print("Sending e-mail with order rejection to User...");
        System.out.println(user.getEmail());
        System.out.println();
    }
}
