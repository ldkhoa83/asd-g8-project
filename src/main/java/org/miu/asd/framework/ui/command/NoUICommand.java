package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UICommandBean;

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
