package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.DepositDialog;
import org.miu.asd.framework.ui.FrameConfig;
import org.miu.asd.framework.ui.FrameTemplate;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CreditCardMainFrame extends FrameTemplate {

    public CreditCardMainFrame(AccountService accountService, FrameConfig frameConfig) {
        super(accountService, frameConfig);
        init("No title");
    }

    public CreditCardMainFrame(AccountService accountService, FrameConfig frameConfig, String title) {
        super(accountService,frameConfig);
        init(title);
    }

    private final ActionListener createCreditCardAccount = (actionEvent) -> {
        openDialog(new JDialog_AddCCAccount(this,getAccountService()));
    };

    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new DepositDialog(this, creditCardNumber, customerName, getAccountService()),430, 15, 275, 200);
        }
    };

    private final ActionListener charge = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new ChargeDialog(this, creditCardNumber, getAccountService()),430, 15, 275, 140);
        }
    };

    private final ActionListener generateBill = (ActionListener) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new JDialogGenBill(this, getAccountService(), creditCardNumber), 450, 20, 400, 350);
        }
    };

    @Override
    public void init(String title) {
        Map<String,ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add credit account",new ButtonConfig(createCreditCardAccount,24,20,192,33));
        buttons.put("Deposit",new ButtonConfig(deposit,468,104,96,33));
        buttons.put("Charge", new ButtonConfig(charge,468,164,96,33));
        buttons.put("Generate Bill", new ButtonConfig(generateBill,240,20,192,33));
        buttons.put("Exit",new ButtonConfig(getExitEventHandler(),468,248,96,31));
        constructFrame(title,buttons);
    }
}
