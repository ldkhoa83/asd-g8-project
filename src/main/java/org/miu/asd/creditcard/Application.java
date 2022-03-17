package org.miu.asd.creditcard;

import org.miu.asd.creditcard.service.CreditCardAccountService;
import org.miu.asd.creditcard.ui.*;
import org.miu.asd.creditcard.ui.command.AddCreditCardAccountUICommand;
import org.miu.asd.creditcard.ui.command.BillCreationUICommand;
import org.miu.asd.creditcard.ui.command.ChargeUICommand;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.ui.command.DepositUICommand;
import org.miu.asd.framework.ui.command.FrameUpdateUICommand;

public class Application {
    public static void main(String[] args) {
        CreditCardAccountService service = new CreditCardAccountService(new MemoryAccountDAO());
        CreditCardMainFrame creditCardMainFrame = CreditCardMainFrameBuilder.getInstance()
                .withAccountService(service)
                .withTitle("Credit Card Application")
                .withMainFrameConfig(new CreditCardFrameConfig())
                .withAddAccountCommand(new AddCreditCardAccountUICommand(service))
                .withBillCreationCommand(new BillCreationUICommand(service))
                .withFrameUpdateCommand(new FrameUpdateUICommand(service))
                .withChargeCommand(new ChargeUICommand(service))
                .withDepositCommand(new DepositUICommand(service))
                .build();
        creditCardMainFrame.setVisible(true);
    }
}
