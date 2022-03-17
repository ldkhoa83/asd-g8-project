package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UICommandBean;

public abstract class UICommand<T extends UICommandBean> {
    private AccountService accountService;

    public UICommand(AccountService accountService){
        this.accountService = accountService;
    }

    public abstract void execute(T bean);

    protected AccountService getAccountService(){
        return accountService;
    }
}
