package org.miu.asd.framework.dao;

import org.miu.asd.framework.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class MemoryAccountDAO implements AccountDAO {
    Collection<Account> accountList = new ArrayList<>();

    public Collection<Account> getAccounts() {
        return accountList;
    }
    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        Account accountExist = loadAccount(account.getAccountNumber());
        if (accountExist != null) {
            accountList.remove(accountExist); // remove the old
            accountList.add(account); // add the new
        }
    }

    @Override
    public void saveAccount(Account account) {
        accountList.add(account); // add the new
    }

    @Override
    public Collection<Account> loadAllAccounts() {
        return accountList;
    }
}
