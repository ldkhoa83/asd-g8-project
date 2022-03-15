package org.miu.asd.banking.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class AddPersonalAccountUICommand extends UICommand {
    public AddPersonalAccountUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {

    }
}
