package org.miu.asd.creditcard.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.miu.asd.framework.domain.*;

public class CreditCardAccount extends Account {
    private LocalDate expiredDate;
    private CreditCardType creditCardType;

    public CreditCardAccount(String accountNumber, Customer customer, LocalDate expiredDate, CreditCardType creditCardType) {
        super(accountNumber, customer);
        this.expiredDate = expiredDate;
        this.creditCardType = creditCardType;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    @Override
    public Report generateReport(Interval interval) {
        return null;
    }
}
