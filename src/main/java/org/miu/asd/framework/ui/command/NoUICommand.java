package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UICommandBean;

public class NoUICommand implements UICommand<UICommandBean> {
    private AccountService accountService;

    public NoUICommand(){}

    public NoUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(UICommandBean bean) {

    }

}
