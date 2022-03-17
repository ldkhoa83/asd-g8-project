package org.miu.asd.creditcard.domain.calculator.strategy;

public class GoldPaymentCalculator implements CreditPaymentStrategy {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.06;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.1;
    }
}
