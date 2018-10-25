package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final Bread bread;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    public static class BigmacBuilder {
        private Bread bread;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bread(String type) {
            this.bread = new Bread(type);
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String taste) {
            this.sauce = new Sauce(taste);
            return this;
        }

        public BigmacBuilder ingredients(String type) {
            ingredients.add(new Ingredient(type));
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bread, burgers, sauce, ingredients);
        }
    }

    public Bigmac(final Bread bread, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bread = bread;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bread getBread() {
        return bread;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac:" +
                "\nbread=" + bread +
                "\nburgers=" + burgers +
                "\nsauce=" + sauce +
                "\ningredients=" + ingredients;
    }
}
