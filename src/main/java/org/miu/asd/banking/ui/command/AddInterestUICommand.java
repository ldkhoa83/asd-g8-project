package org.miu.asd.banking.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;

public class AddInterestUICommand implements UICommand<BaseUIBean> {
    private AccountService accountService;

    public AddInterestUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(BaseUIBean bean) {
        accountService.addInterestForAllAccounts();
    }
}
