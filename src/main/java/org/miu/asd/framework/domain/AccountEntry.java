package org.miu.asd.framework.domain;

import org.joda.time.LocalDateTime;

public class AccountEntry{
    private AccountEvent accountEvent;
    private Double amountOfMoney;
    private LocalDateTime whenRecorded;

    public AccountEntry(Double amountOfMoney, AccountEvent accountEvent, LocalDateTime whenRecorded){
        this.amountOfMoney = amountOfMoney;
        this.accountEvent = accountEvent;
        this.whenRecorded = whenRecorded;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public AccountEvent getAccountEvent() {
        return accountEvent;
    }

    public LocalDateTime getWhenRecorded() {
        return whenRecorded;
    }
}
