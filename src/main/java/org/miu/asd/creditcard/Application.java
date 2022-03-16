package org.miu.asd.creditcard;

import org.miu.asd.creditcard.service.CreditCardAccountService;
import org.miu.asd.creditcard.ui.*;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.ui.DepositUICommand;
import org.miu.asd.framework.ui.FrameUpdateUICommand;

public class Application {
    public static void main(String[] args) {
        CreditCardAccountService service = new CreditCardAccountService(new MemoryAccountDAO());
        CreditCardMainFrame creditCardMainFrame = new CreditCardMainFrame(new CreditCardUIConfig(), "Credit Card Application.");
        creditCardMainFrame.setAddCreditCardAccountCommand(new AddCCAccountUICommand(service));
        creditCardMainFrame.setBillReportCommand(new BillCreationUICommand(service));
        creditCardMainFrame.setFrameUpdateCommand(new FrameUpdateUICommand(service));
        creditCardMainFrame.setDepositCommand(new DepositUICommand(service));
        creditCardMainFrame.setChargeCreditCardCommand(new ChargeUICommand(service));
        creditCardMainFrame.setVisible(true);
    }
}
