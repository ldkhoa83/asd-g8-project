package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;

public class FrameUpdateUICommand extends UICommand<BaseUIBean> {

    public FrameUpdateUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(BaseUIBean bean) {
        bean.setAllAccounts(getAccountService().getAllAccounts());
    }
}
