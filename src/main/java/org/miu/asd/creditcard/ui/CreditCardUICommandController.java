package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.ui.command.UICommand;
import org.miu.asd.framework.ui.UICommandController;

public interface CreditCardUICommandController extends UICommandController {
    void setAddCreditCardAccountCommand(UICommand<CreditCardUIBean> addCreditCardAccountCommand);
    void setBillReportCommand(UICommand<CreditCardUIBean> billReportCommand);
    void setChargeCreditCardCommand(UICommand<CreditCardUIBean> chargeCreditCardCommand);
}
