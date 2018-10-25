package com.kodilla.patterns.builder.bigmac;

public final class Bread {
    public static final String ROLL = "Roll";
    public static final String BUN_SESAME = "Bun with sesame seeds";
    public static final String BUN_NO_SESAME = "Bun without sesame seeds";
    private final String type;

    public Bread(final String type) {
        if (type.equals(ROLL) || type.equals(BUN_NO_SESAME) || type.equals(BUN_SESAME)) {
            this.type = type;
        } else {
            throw new IllegalStateException("Possible bread is Roll and Bun with/without sesame seeds.");
        }
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "type='" + type + '\'' +
                '}';
    }
}
