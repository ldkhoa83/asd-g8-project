package org.miu.asd.framework.domain;

import java.util.Collection;
import java.util.HashSet;

public abstract class Party {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    private Collection<Account> accounts = new HashSet<>();

    public Party(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
}
