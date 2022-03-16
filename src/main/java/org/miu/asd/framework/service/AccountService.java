package org.miu.asd.framework.service;


import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.AccountFactory;
import org.miu.asd.framework.domain.Customer;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountID, Customer customer, AccountFactory accountFactory);

    Account getAccount(String accountID);

    void deposit(String accountID, Double amountOfMoney, AccountEvent accountEvent);

    void withdraw(String accountID, Double amountOfMoney, AccountEvent accountEvent);

    Collection<Account> getAllAccounts();

    default void charge(String accountID, Double amountOfMoney, AccountEvent accountEvent){
        withdraw(accountID,amountOfMoney,accountEvent);
    }

    String generateMonthlyBillReport(String AccountID);
}
