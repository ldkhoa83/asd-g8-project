package org.miu.asd.creditcard.domain.interestandpaymentcalculator;

import org.miu.asd.banking.domain.interestCalculator.InterestComputationStrategy;


public interface CreditPaymentCalculator extends InterestComputationStrategy {
    double calculateTotalDue(Double balance);

    default double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + computeInterest (prevBalance - totalCredit);
    }
}
