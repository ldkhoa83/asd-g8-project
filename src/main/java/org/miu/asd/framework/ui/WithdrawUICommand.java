package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

public class WithdrawUICommand extends UICommand{
    public WithdrawUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        getAccountService().withdraw(bean.getAccountNumber(),bean.getAmount(),null);
    }
}
