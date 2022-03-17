package org.miu.asd.framework.service;


import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.AccountFactory;
import org.miu.asd.framework.domain.Customer;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, Customer customer, AccountFactory accountFactory);

    Account getAccount(String accountNumber);

    void deposit(String accountNumber, Double amountOfMoney, AccountEvent accountEvent);

    void withdraw(String accountNumber, Double amountOfMoney, AccountEvent accountEvent);

    Collection<Account> getAllAccounts();

    default void charge(String accountNumber, Double amountOfMoney, AccountEvent accountEvent){
        withdraw(accountNumber,amountOfMoney,accountEvent);
    }

    String generateMonthlyBillReport(String accountNumber);

    String generateAllAccountReports();

    void addInterestForAllAccounts();
}
