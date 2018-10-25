package com.kodilla.patterns.builder.bigmac;

public final class Sauce {
    public static final String STANDARD = "STANDARD";
    public static final String ISLANDS_1000 = "1000 ISLANDS";
    public static final String BARBECUE = "BARBECUE";
    private final String taste;

    public Sauce(final String taste) {
        if (taste.equals(STANDARD) || taste.equals(ISLANDS_1000) || taste.equals(BARBECUE)) {
            this.taste = taste;
        } else {
            throw new IllegalStateException("Possible sauce is Standard, 1000 Islands or Barbecue!");
        }
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public String toString() {
        return "Sauce{" +
                "taste='" + taste + '\'' +
                '}';
    }
}
