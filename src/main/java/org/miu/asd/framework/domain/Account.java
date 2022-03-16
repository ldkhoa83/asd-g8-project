package org.miu.asd.framework.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.miu.asd.banking.domain.interestCalculator.PersonalCheckingInterest;

import java.util.Collection;
import java.util.HashSet;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private InterestComputationStrategy interestComputationStrategy;
    private Collection<AccountEntry> accountEntries = new HashSet<>();

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.interestComputationStrategy = new PersonalCheckingInterest(); // constructor injection
    }

    public Double balance(Interval interval) {
        return accountEntries.stream()
                .filter(entry -> interval.contains(entry.getWhenRecorded().toDateTime()))
                .map(AccountEntry::getAmountOfMoney)
                .reduce((x,y) -> x + y).orElse(0.0);
    }

    public Double balance(LocalDate upToDate) {
        Interval sinceLastYear = new Interval(Period.years(1), upToDate.toDateTimeAtCurrentTime());
        return balance(sinceLastYear);
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

    public AccountEntry addInterest(){
        LocalDateTime time = LocalDateTime.now();
        AccountEvent accountEvent = new BasicAccountEvent(time, customer.getName(), AccountEventType.INTEREST);
        AccountEntry accountEntry = new AccountEntry(interestComputationStrategy.computeInterest(balance()), accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    public AccountEntry withdraw(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = new AccountEntry(-amountOfMoney, accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    protected Collection<AccountEntry> getAccountEntries() {
        return accountEntries;
    }

    public abstract String generateReport(Interval interval);

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }
}
