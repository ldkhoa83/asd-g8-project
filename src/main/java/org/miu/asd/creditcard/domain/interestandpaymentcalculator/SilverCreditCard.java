package org.miu.asd.creditcard.domain.interestandpaymentcalculator;

import org.miu.asd.framework.domain.CreditPaymentCalculator;

public class SilverCreditCard implements CreditPaymentCalculator {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.08;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.12;
    }
}
