package org.miu.asd.banking.domain;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.domain.AccountFactory;

public class CheckingAccountFactory implements AccountFactory {
    @Override
    public Account initAccount(String accountNumber, Customer customer) {
        return new CheckingAccount(accountNumber,customer);
    }
}
