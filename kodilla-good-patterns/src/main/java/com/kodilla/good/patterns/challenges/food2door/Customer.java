package com.kodilla.good.patterns.challenges.food2door;

public class Customer {
    private String name;
    private String eMail;

    public Customer(final String name, final String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
