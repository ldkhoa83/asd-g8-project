package org.miu.asd.framework.ui;

import org.miu.asd.framework.service.AccountService;

public class FrameUpdateUICommand extends UICommand<UIBean> {

    public FrameUpdateUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {

    }
}
