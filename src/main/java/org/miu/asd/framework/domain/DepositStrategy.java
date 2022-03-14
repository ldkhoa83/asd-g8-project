package org.miu.asd.framework.domain;

public interface DepositStrategy {
    AccountEntry deposit(Double amountOfMoney, AccountEvent accountEvent);
}
