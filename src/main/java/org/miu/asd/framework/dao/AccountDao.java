package org.miu.asd.framework.dao;

import org.miu.asd.framework.domain.Account;

public interface AccountDao {
    Account getAccount(String accountID);
    void updateAccount(Account account);
    void saveAccount(Account account);
}
