package org.miu.asd.framework.domain;

import java.util.Collection;
import java.util.HashSet;

public class Customer {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    private Collection<Account> accounts = new HashSet<>();

    public Customer(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }
}
