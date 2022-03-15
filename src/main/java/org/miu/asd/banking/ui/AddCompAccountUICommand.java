package org.miu.asd.banking.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class AddCompAccountUICommand extends UICommand {
    public AddCompAccountUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {

    }
}
