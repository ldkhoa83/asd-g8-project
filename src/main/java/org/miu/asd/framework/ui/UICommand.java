package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

import java.awt.event.ActionListener;

public abstract class UICommand<T extends AccountService> {
    private T accountService;

    public UICommand(T accountService){
        this.accountService = accountService;
    }

    public abstract void execute(UIBean bean);

    protected T getAccountService(){
        return accountService;
    }
}
