package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class ChargeUICommand extends UICommand {
    public ChargeUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {

    }
}
