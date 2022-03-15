package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

import java.awt.event.ActionListener;

public abstract class UICommand {
    private AccountService accountService;

    public UICommand(AccountService accountService){
        this.accountService = accountService;
    }

    public abstract void execute(UIBean bean);

    protected AccountService getAccountService(){
        return accountService;
    }
}
