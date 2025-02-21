package com.hideki.pawnshopSystem.enums;

public enum Purity {
    K24("24K"),
    K22("22K"),
    K21("21K"),
    K18_JAP("18K_JAP"),
    K18_SAUDI("18K_SAUDI"),
    K18("18K"),
    K14("14K"),
    K10("10K"),
    PT900("PT900"),
    PT850("PT850");

    private final String value;

    Purity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Purity fromValue(String value) {
        for (Purity p : values()) {
            if (p.value.equals(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Unknown purity: " + value);
    }
}



