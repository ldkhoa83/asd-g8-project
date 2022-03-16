package org.miu.asd.framework.domain;

public interface CreditPaymentCalculator extends InterestComputationStrategy{
    double calculateTotalDue(Double balance);

    default double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + computeInterest (prevBalance - totalCredit);
    }
}
