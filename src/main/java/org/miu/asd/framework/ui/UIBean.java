package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class UIBean implements UICommandBean{
    private String accountType;
    private String accountNumber;
    private Customer customer;
    private Double amount;
    private Collection<Account> accounts;

    public UIBean() {
        this.accountType = "";
        this.accountNumber = "";
        this.amount = 0.0;
        this.accounts = new ArrayList<>();
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

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public void setAllAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
