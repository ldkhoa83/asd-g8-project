package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

public class NoUICommand extends UICommand {

    public NoUICommand(){
        super(null);
    }

    public NoUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UICommandBean bean) {

    }

}
