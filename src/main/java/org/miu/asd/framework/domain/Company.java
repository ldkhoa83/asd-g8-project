package org.miu.asd.framework.domain;

import org.miu.asd.framework.domain.Customer;

public class Company extends Customer {
    private Integer numOfEmployees;

    public Company(String name, String street, String city, String state, String zipCode, Integer numOfEmployees) {
        super(name, street, city, state, zipCode);
        this.numOfEmployees = numOfEmployees;
    }

    public Integer getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(Integer numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }
}
