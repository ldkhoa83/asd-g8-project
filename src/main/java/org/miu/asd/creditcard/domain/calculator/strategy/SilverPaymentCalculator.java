package org.miu.asd.creditcard.domain.calculator.strategy;

public class SilverPaymentCalculator implements CreditPaymentStrategy {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.08;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.12;
    }
}
