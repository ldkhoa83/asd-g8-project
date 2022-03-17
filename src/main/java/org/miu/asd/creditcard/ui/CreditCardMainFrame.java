package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.creditcard.ui.dialog.AddCreditCardAccountDialog;
import org.miu.asd.creditcard.ui.dialog.BillReportDialog;
import org.miu.asd.creditcard.ui.dialog.ChargeDialog;
import org.miu.asd.framework.ui.*;
import org.miu.asd.framework.ui.command.UICommand;
import org.miu.asd.framework.ui.dialog.DepositDialog;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CreditCardMainFrame extends FrameTemplate implements CreditCardUICommandController{

    private UICommand<CreditCardUIBean> addCreditCardAccountCommand;
    private UICommand<CreditCardUIBean> billReportCommand;
    private UICommand<CreditCardUIBean> chargeCreditCardCommand;

    CreditCardMainFrame(FrameConfig frameConfig) {
        super(frameConfig);
        constructFrame(NO_TITLE);
    }

     CreditCardMainFrame(FrameConfig frameConfig, String title) {
        super(frameConfig);
        constructFrame(title);
    }

    private final ActionListener createCreditCardAccount = (actionEvent) -> {
        openDialog(new AddCreditCardAccountDialog(this, addCreditCardAccountCommand));
    };

    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new DepositDialog(this, creditCardNumber, customerName, getDepositCommand()),430, 15, 275, 200);
        }
    };

    private final ActionListener charge = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new ChargeDialog(this, creditCardNumber, chargeCreditCardCommand),430, 15, 275, 140);
        }
    };

    private final ActionListener generateBill = (ActionListener) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new BillReportDialog(this, this.billReportCommand, creditCardNumber), 450, 20, 400, 350);
        }
    };

    @Override
    public Map<String, ButtonConfig> buttonConfigs() {
        Map<String,ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add credit account",new ButtonConfig(createCreditCardAccount,24,20,192,33));
        buttons.put("Deposit",new ButtonConfig(deposit,468,104,96,33));
        buttons.put("Charge", new ButtonConfig(charge,468,144,96,33));
        buttons.put("Generate Bill", new ButtonConfig(generateBill,240,20,192,33));
        buttons.put("Exit",new ButtonConfig(getExitEventHandler(),468,248,96,31));
        return buttons;
    }

    @Override
    public void setAddCreditCardAccountCommand(UICommand<CreditCardUIBean> addCreditCardAccountCommand) {
        this.addCreditCardAccountCommand = addCreditCardAccountCommand;
    }

    @Override
    public void setBillReportCommand(UICommand<CreditCardUIBean> billReportCommand) {
        this.billReportCommand = billReportCommand;
    }

    @Override
    public void setChargeCreditCardCommand(UICommand<CreditCardUIBean> chargeCreditCardCommand) {
        this.chargeCreditCardCommand = chargeCreditCardCommand;
    }
}
