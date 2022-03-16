package org.miu.asd.framework.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.miu.asd.banking.domain.interestCalculator.CheckingInterest;
import org.miu.asd.banking.domain.interestCalculator.InterestComputationStrategy;
import org.miu.asd.banking.domain.interestCalculator.SavingInterest;
import org.miu.asd.banking.ui.AccountType;

import java.util.Collection;
import java.util.HashSet;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private Collection<AccountEntry> accountEntries = new HashSet<>();
    private InterestComputationStrategy interestComputationStrategy;

    public Account(String accountNumber, Customer customer, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        if(accountType.equals(AccountType.CHECKING)) {
            this.interestComputationStrategy = new CheckingInterest();
        } else if(accountType.equals(AccountType.SAVING)) {
            this.interestComputationStrategy = new SavingInterest();
        }
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

    public Double computeWithdraws(Interval interval){
        return getAccountEntries().stream()
                .filter(entry -> interval.contains(entry.getWhenRecorded().toDateTime()))
                .filter(accountEntry -> accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.WITHDRAW)
                .map(AccountEntry::getAmountOfMoney)
                .reduce((x,y) -> x + y).orElse(0.0);
    }

    public Double computeDeposits(Interval interval){
        return getAccountEntries().stream()
                .filter(entry -> interval.contains(entry.getWhenRecorded().toDateTime()))
                .filter(accountEntry -> accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.DEPOSIT)
                .map(AccountEntry::getAmountOfMoney)
                .reduce((x,y) -> x + y).orElse(0.0);
    }

    public void setAccountEntries(Collection<AccountEntry> accountEntries) {
        this.accountEntries = accountEntries;
    }

    public AccountEntry deposit(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = new AccountEntry(amountOfMoney, accountEvent, LocalDateTime.now());
        accountEntries.add(accountEntry);
        return accountEntry;
    }

    public AccountEntry addInterest(){
        LocalDateTime time = LocalDateTime.now();
        AccountEvent accountEvent = new BasicAccountEvent(time, getCustomer().getName(), AccountEventType.INTEREST);
        AccountEntry accountEntry = new AccountEntry(interestComputationStrategy.computeInterest(balance()), accountEvent, LocalDateTime.now());
        getAccountEntries().add(accountEntry);
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
