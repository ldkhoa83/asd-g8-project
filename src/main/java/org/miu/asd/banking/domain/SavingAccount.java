package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.banking.domain.interestCalculator.CheckingInterest;
import org.miu.asd.banking.domain.interestCalculator.SavingInterest;
import org.miu.asd.banking.ui.AccountType;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.banking.domain.interestCalculator.InterestComputationStrategy;

import java.io.StringWriter;

public class SavingAccount extends Account {

    public SavingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
        super.setInterestStrategy(new SavingInterest());
    }

    @Override
    public String generateReport(Interval interval) {
        StringWriter sb = new StringWriter();
        sb.append("======SAVING ACCOUNT REPORT=====").append("\n");
        sb.append("Account Number: ").append(getAccountNumber()).append("\n");
        sb.append("Customer name: ").append(getCustomer().getName()).append("\n");
        sb.append("Current balance: ").append(balance(interval).toString()).append("\n");
        sb.append("***TRANSACTIONS***").append("\n");
        getAccountEntries().stream()
                .filter(accountEntry -> interval.contains(accountEntry.getWhenRecorded().toDateTime()))
                .forEach(accountEntry -> sb.append("From source: ").append(accountEntry.getAccountEvent().getSourceName())
                        .append("-").append("Type: ").append(accountEntry.getAccountEvent().getAccountEventType().name())
                        .append("-").append("Amount: ").append(accountEntry.getAmountOfMoney().toString())
                        .append("-").append("When: ").append(accountEntry.getWhenRecorded().toString()).append("\n"));

        return sb.toString();
    }
}
