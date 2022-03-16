package org.miu.asd.banking.service;

import org.miu.asd.banking.domain.SavingAccount;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.service.AccountFactory;

public class SavingAccountFactory implements AccountFactory {
    @Override
    public Account initAccount(String accountID, Customer customer) {
        return new SavingAccount(accountID,customer);
    }
}
