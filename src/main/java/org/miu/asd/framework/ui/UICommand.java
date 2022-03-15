package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

import java.awt.event.ActionListener;

public abstract class ButtonCommand implements ActionListener {
    private AccountService accountService;

    public ButtonCommand(AccountService accountService){
        this.accountService = accountService;
    }
}
