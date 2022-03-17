package org.miu.asd.creditcard.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.miu.asd.creditcard.domain.calculator.strategy.CreditPaymentStrategy;
import org.miu.asd.framework.domain.*;


public class CreditCardAccount extends Account {
    private LocalDate expiredDate;
    private CreditPaymentStrategy creditPaymentStrategy;
    private CreditCardType creditCardType;

    public CreditCardAccount(String accountNumber, Customer customer, LocalDate expiredDate, CreditCardType creditCardType, CreditPaymentStrategy creditPaymentStrategy) {
        super(accountNumber, customer);
        this.expiredDate = expiredDate;
        this.creditCardType = creditCardType;
        this.creditPaymentStrategy = creditPaymentStrategy;
    }

    public CreditCardAccount(String accountNumber, Customer customer){
        super(accountNumber,customer);
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public String generateReport(Interval interval) {
        Double previousBalance = balance(interval.getStart().toLocalDate());
        Double totalCharges = getAccountEntries().stream()
                .filter(entry -> interval.contains(entry.getWhenRecorded().toDateTime()))
                .filter(accountEntry -> accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.CHARGED)
                .map(AccountEntry::getAmountOfMoney)
                .reduce((x,y) -> x + y).orElse(0.0);
        Double totalCredits = computeDeposits(interval);
        Double newBalance= creditPaymentStrategy.calculateBalance(previousBalance,totalCharges, totalCredits);
        Double totalDue= creditPaymentStrategy.calculateTotalDue(newBalance);
        return buildReportContent(previousBalance,totalCharges,totalCredits,newBalance ,totalDue);
    }

    private String buildReportContent(Double previousBalance,Double totalCharges, Double totalCredits, Double newBalance, Double duePayment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("- Previous balance: ").append(previousBalance).append('\n');
        stringBuilder.append("- Total charges: ").append(totalCharges).append('\n');
        stringBuilder.append("- Total credits: ").append(totalCredits).append('\n');
        stringBuilder.append("- New balance: ").append(newBalance).append('\n');
        stringBuilder.append("- Due payment: ").append(duePayment);
        return stringBuilder.toString();
    }


}
