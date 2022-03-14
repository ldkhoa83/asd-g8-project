package org.miu.asd.framework.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import java.util.Collection;
import java.util.HashSet;

public abstract class Account {
    private Collection<AccountEntry> accountEntries = new HashSet<>();
    private DepositStrategy depositStrategy;
    private WithdrawStrategy withdrawStrategy;

    public Account(DepositStrategy depositStrategy, WithdrawStrategy withdrawStrategy) {
        this.depositStrategy = depositStrategy;
        this.withdrawStrategy = withdrawStrategy;
    }

    public Double balance(Interval interval) {
        return null;
    }

    public Double balance(LocalDate upToDate) {
        return null;
    }

    public Double balance() {
        return null;
    }

    public void deposit(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = depositStrategy.deposit(amountOfMoney,accountEvent);
        accountEntries.add(accountEntry);
    }

    public void withdraw(Double amountOfMoney, AccountEvent accountEvent){
        AccountEntry accountEntry = withdrawStrategy.withdraw(amountOfMoney,accountEvent);
        accountEntries.add(accountEntry);
    }

    public abstract Report generateReport(Interval interval);
}
