package org.miu.asd.framework.dao;

import org.miu.asd.framework.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class MemoryAccountDAO implements AccountDAO {
    Collection<Account> accountlist = new ArrayList<>();

    public Collection<Account> getAccounts() {
        return accountlist;
    }
    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
    }

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    @Override
    public Collection<Account> loadAllAccounts() {
        return accountlist;
    }
}
