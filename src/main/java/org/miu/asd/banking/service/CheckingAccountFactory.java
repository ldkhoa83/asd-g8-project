package org.miu.asd.banking.service;

import org.miu.asd.banking.domain.CheckAccount;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.service.AccountFactory;

public class CheckingAccountFactory implements AccountFactory {
    @Override
    public Account initAccount(String accountID, Customer customer) {
        return new CheckAccount(accountID,customer);
    }
}
