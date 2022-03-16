package org.miu.asd.banking.service;

import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.service.BasicAccountService;

public class BankAccountService extends BasicAccountService {

    public BankAccountService(AccountDAO accountDao) {
        super(accountDao);
    }

    protected void addInterestForAllAccounts(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        account.withdraw(amountOfMoney,accountEvent);
    }

    protected AccountEntry performWithdrawOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return account.withdraw(amountOfMoney,accountEvent);
    }

    @Override
    protected AccountEntry performDepositOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return account.deposit(amountOfMoney,accountEvent);
    }

}
