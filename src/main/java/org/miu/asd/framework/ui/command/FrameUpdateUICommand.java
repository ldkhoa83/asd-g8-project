package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;

public class FrameUpdateUICommand implements UICommand<BaseUIBean> {
    private AccountService accountService;

    public FrameUpdateUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(BaseUIBean bean) {
        bean.setAllAccounts(accountService.getAllAccounts());
    }
}
