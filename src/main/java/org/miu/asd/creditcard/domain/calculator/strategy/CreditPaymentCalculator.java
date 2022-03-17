package org.miu.asd.creditcard.domain.calculator.strategy;

import org.miu.asd.banking.domain.calculator.strategy.InterestComputationStrategy;


public interface CreditPaymentCalculator extends InterestComputationStrategy {
    double calculateTotalDue(Double balance);

    default double calculateBalance(double prevBalance, double totalCharge,double totalCredit) {
        return prevBalance - totalCredit + totalCharge + computeInterest (prevBalance - totalCredit);

    }
}
