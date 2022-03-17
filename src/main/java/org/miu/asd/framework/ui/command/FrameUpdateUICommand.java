package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UIBean;

public class FrameUpdateUICommand extends UICommand<UIBean> {

    public FrameUpdateUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        bean.setAllAccounts(getAccountService().getAllAccounts());
    }
}
