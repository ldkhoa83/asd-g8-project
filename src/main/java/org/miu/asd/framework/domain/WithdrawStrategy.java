package org.miu.asd.framework.domain;

public interface WithdrawStrategy {
    AccountEntry withdraw(Double amountOfMoney, AccountEvent accountEvent);
}
