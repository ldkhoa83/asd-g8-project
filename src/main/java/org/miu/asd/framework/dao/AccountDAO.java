package org.miu.asd.framework.dao;

import org.miu.asd.framework.domain.Account;

import java.util.Collection;

public interface AccountDAO {
    Account loadAccount(String accountNumber);

    void updateAccount(Account account);

    void saveAccount(Account account);

    Collection<Account> loadAllAccounts();
}
