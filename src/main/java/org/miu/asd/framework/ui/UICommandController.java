package org.miu.asd.framework.ui;

public interface UICommandController {

    void setFrameUpdateCommand(UICommand<UIBean> frameUpdateCommand);
    void setDepositCommand(UICommand<UIBean> depositUICommand);
    void setWithdrawCommand(UICommand<UIBean> withdrawUICommand);
}
