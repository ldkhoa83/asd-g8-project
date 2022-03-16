package org.miu.asd.framework.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.Collection;
import java.util.HashSet;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private Collection<AccountEntry> accountEntries = new HashSet<>();
    private InterestComputationStrategy interestStrategy;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public Double balance(Interval interval) {
        return null;
    }

    public Double balance(LocalDate upToDate) {
        return null;
    }

    public Double balance() {
        Double currentBalance = 0.0;
        for(AccountEntry accountEntry : accountEntries){
            currentBalance += accountEntry.getAmountOfMoney();
        }
        return currentBalance;
    }

    public AccountEntry deposit(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = new AccountEntry(amountOfMoney, accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    public AccountEntry withdraw(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = new AccountEntry(-amountOfMoney, accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    public AccountEntry addInterest(){
        Double calculatedInterest=interestStrategy.computeInterest(balance());
        AccountEvent accountEvent=new AccountEventImpl(LocalDateTime.now(),null,AccountEventTypeImpl.INTEREST);
        AccountEntry accountEntry = new AccountEntry(calculatedInterest, accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    public abstract Report generateReport(Interval interval);

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }


}
