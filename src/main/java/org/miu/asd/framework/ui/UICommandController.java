package org.miu.asd.framework.ui;

import org.miu.asd.framework.ui.bean.UIBean;
import org.miu.asd.framework.ui.command.UICommand;

public interface UICommandController {

    void setFrameUpdateCommand(UICommand<UIBean> frameUpdateCommand);
    void setDepositCommand(UICommand<UIBean> depositUICommand);
    void setWithdrawCommand(UICommand<UIBean> withdrawUICommand);
}
