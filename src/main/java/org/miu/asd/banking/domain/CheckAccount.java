package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.domain.DepositStrategy;
import org.miu.asd.framework.domain.WithdrawStrategy;

public class CheckAccount extends Account {

    public CheckAccount(String accountNumber, Customer customer, DepositStrategy depositStrategy, WithdrawStrategy withdrawStrategy) {
        super(accountNumber, customer, depositStrategy, withdrawStrategy);
    }

    @Override
    public BankingReport generateReport(Interval interval) {
        return null;
    }
}
