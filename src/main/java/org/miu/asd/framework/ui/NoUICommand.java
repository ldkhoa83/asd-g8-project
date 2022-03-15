package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

import java.awt.event.ActionEvent;

public class NoButtonCommand extends UICommand {

    public NoButtonCommand(){
        super(null);
    }

    public NoButtonCommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
