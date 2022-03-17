package org.miu.asd.framework.ui;

import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;

public interface UICommandController {

    void setFrameUpdateCommand(UICommand<BaseUIBean> frameUpdateCommand);
    void setDepositCommand(UICommand<BaseUIBean> depositUICommand);
    void setWithdrawCommand(UICommand<BaseUIBean> withdrawUICommand);
}
