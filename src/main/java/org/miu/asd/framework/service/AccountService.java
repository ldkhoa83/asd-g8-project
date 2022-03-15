package org.miu.asd.framework.service;


import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEvent;

import java.util.Collection;
import java.util.Map;

public interface AccountService {
    Account getAccount(String accountID);
    void deposit(String accountID, Double amountOfMoney, AccountEvent accountEvent);
    void withdraw(String accountID, Double amountOfMoney, AccountEvent accountEvent);

    Collection<Account> getAllAccounts();
}
