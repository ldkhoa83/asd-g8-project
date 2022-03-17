package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.service.CreditCardAccountService;
import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.creditcard.ui.command.AddCreditCardAccountUICommand;
import org.miu.asd.creditcard.ui.command.BillCreationUICommand;
import org.miu.asd.creditcard.ui.command.ChargeUICommand;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.*;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.DepositUICommand;
import org.miu.asd.framework.ui.command.FrameUpdateUICommand;
import org.miu.asd.framework.ui.command.UICommand;

public class CreditCardMainFrameBuilder {
    private static final CreditCardMainFrameBuilder INSTANCE = new CreditCardMainFrameBuilder();

    private static AccountService accountService = new CreditCardAccountService(new MemoryAccountDAO());
    private static CreditCardFrameConfig mainFrameConfig = new CreditCardFrameConfig();
    private static UICommand<CreditCardUIBean> addAccountUICommand = new AddCreditCardAccountUICommand(accountService);
    private static UICommand<BaseUIBean> frameUpdateUICommand = new FrameUpdateUICommand(accountService);
    private static UICommand<BaseUIBean> depositUICommand = new DepositUICommand(accountService);
    private static UICommand<CreditCardUIBean> chargeUICommand = new ChargeUICommand(accountService);
    private static UICommand<CreditCardUIBean> billCreationUICommand = new BillCreationUICommand(accountService);
    private static String frameTitle = FrameTemplate.NO_TITLE;

    private CreditCardMainFrameBuilder(){}

    public static CreditCardMainFrameBuilder getInstance(){
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withAccountService(AccountService service){
        accountService = service;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withFrameUpdateCommand(UICommand<BaseUIBean> frameUpdateCommand){
        frameUpdateUICommand = frameUpdateCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withDepositCommand(UICommand<BaseUIBean> depositCommand){
        depositUICommand = depositCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withAddAccountCommand(UICommand<CreditCardUIBean> addAccountCommand){
        addAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withChargeCommand(UICommand<CreditCardUIBean> chargeCommand){
        chargeUICommand = chargeCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withBillCreationCommand(UICommand<CreditCardUIBean> billCreationCommand){
        billCreationUICommand = billCreationCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withMainFrameConfig(CreditCardFrameConfig creditCardUIConfig){
        mainFrameConfig = creditCardUIConfig;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withTitle(String title){
        frameTitle = title;
        return INSTANCE;
    }

    public CreditCardMainFrame build(){
        CreditCardMainFrame creditCardMainFrame = new CreditCardMainFrame(mainFrameConfig,frameTitle);
        creditCardMainFrame.setAddCreditCardAccountCommand(addAccountUICommand);
        creditCardMainFrame.setFrameUpdateCommand(frameUpdateUICommand);
        creditCardMainFrame.setDepositCommand(depositUICommand);
        creditCardMainFrame.setChargeCreditCardCommand(chargeUICommand);
        creditCardMainFrame.setBillReportCommand(billCreationUICommand);

        return creditCardMainFrame;
    }
}
