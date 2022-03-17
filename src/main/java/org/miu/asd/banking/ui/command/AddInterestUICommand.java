package org.miu.asd.banking.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UIBean;
import org.miu.asd.framework.ui.command.UICommand;

public class AddInterestUICommand extends UICommand<UIBean> {
    public AddInterestUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        getAccountService().addInterestForAllAccounts();
    }
}
