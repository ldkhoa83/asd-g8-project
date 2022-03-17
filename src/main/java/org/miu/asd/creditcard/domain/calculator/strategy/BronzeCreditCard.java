package org.miu.asd.creditcard.domain.calculator.strategy;

public class BronzeCreditCard implements CreditPaymentCalculator {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.1;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.14;
    }
}
