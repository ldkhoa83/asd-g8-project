package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Customer;

public class UIBean implements UICommandBean{
    private String accountType;
    private String accountNumber;
    private Customer customer;
    private Double amount;

    public UIBean() {
        this.accountType = "";
        this.accountNumber = "";
        this.customer = null;
        this.amount = 0.0;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
