package org.miu.asd.creditcard.domain;

public enum CreditCardType {
    GOLD("Gold"),SILVER("Silver"),BRONZE("Bronze");

    private String name;

    CreditCardType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
