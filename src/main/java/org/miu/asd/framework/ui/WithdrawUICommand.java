package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

public class DepositUICommand extends UICommand{
    public DepositUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        getAccountService().deposit(bean.getAccountNumber(),bean.getAmount(),null);
    }
}
