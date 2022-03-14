package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.DepositStrategy;
import org.miu.asd.framework.domain.WithdrawStrategy;

public class SavingAccount extends Account {

    public SavingAccount(DepositStrategy depositStrategy, WithdrawStrategy withdrawStrategy) {
        super(depositStrategy, withdrawStrategy);
    }

    @Override
    public BankingReport generateReport(Interval interval) {
        return null;
    }
}
