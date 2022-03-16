package org.miu.asd.banking.ui;

public enum AccountType {
    SAVING("Saving"),CHECKING("Checking"),CREDIT("Credit");

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
