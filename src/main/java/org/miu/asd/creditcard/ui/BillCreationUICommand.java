package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class BillCreationUICommand extends UICommand {
    public BillCreationUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {

    }
}
