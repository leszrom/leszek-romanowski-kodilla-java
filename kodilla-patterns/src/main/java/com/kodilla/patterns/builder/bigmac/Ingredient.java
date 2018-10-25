package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;

public final class Ingredient {
    public static final String LETTUCE = "Lettuce";
    public static final String ONION = "Onion";
    public static final String BACON = "Bacon";
    public static final String CUCUMBER = "Cucumber";
    public static final String PEPPERS = "Peppers";
    public static final String CHILLI = "Chilli";
    public static final String MUSHROOMS = "Mushrooms";
    public static final String SHRIMPS = "Shrimps";
    public static final String CHEESE = "Cheese";

    private static final String[] ingredients = {LETTUCE, ONION, BACON, CUCUMBER, PEPPERS, CHILLI, MUSHROOMS, SHRIMPS, CHEESE};

    private final String type;

    public Ingredient(final String type) {
        if (Arrays.asList(ingredients).contains(type)) {
            this.type = type;
        } else {
            throw  new IllegalStateException("There is no such ingredient");
        }
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "type='" + type + '\'' +
                '}';
    }
}
