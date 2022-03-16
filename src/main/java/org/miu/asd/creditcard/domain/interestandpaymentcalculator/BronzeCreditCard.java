package org.miu.asd.creditcard.domain.interestandpaymentcalculator;

import org.miu.asd.framework.domain.CreditPaymentCalculator;

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
