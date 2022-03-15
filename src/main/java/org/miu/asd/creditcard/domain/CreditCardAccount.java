package org.miu.asd.creditcard.domain;

import org.joda.time.Interval;
import org.miu.asd.framework.domain.*;

public class CreditCardAccount extends Account {
    private String expiredDate;

    public CreditCardAccount(String accountNumber, Customer customer, String expiredDate, DepositStrategy depositStrategy, WithdrawStrategy withdrawStrategy) {
        super(accountNumber, customer, depositStrategy, withdrawStrategy);
        this.expiredDate = expiredDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    @Override
    public Report generateReport(Interval interval) {
        return null;
    }
}
