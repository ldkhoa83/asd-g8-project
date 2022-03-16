package org.miu.asd.banking.ui;

import org.miu.asd.creditcard.ui.CreditCardUIBean;
import org.miu.asd.framework.ui.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankMainFrame extends FrameTemplate implements BankUICommandController{

    private UICommand<UIBean> addAccountCommand;
    private UICommand<UIBean> addInterestUICommand;

    private final ActionListener personalAccount = (actionEvent) -> {
        openDialog(new AddPersonalAccountDialog(this,addAccountCommand));
    };

    private final ActionListener companyAccount = (actionEvent) -> {
        openDialog(new AddCompanyAccountDialog(this,addAccountCommand));
    };

    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new DepositDialog(this, accnr, customerName, getDepositCommand()),430, 15, 275, 140);
        }
    };

    private final ActionListener addInterest = (actionEvent) -> {
            UIBean uiBean = new UIBean();
            addInterestUICommand.execute(uiBean);
            updateContent();

        JOptionPane.showMessageDialog(null, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    };

    private final ActionListener withdraw = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0){
            String accountNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new WithdrawDialog(this, accountNumber, customerName, getWithdrawCommand()),430, 15, 275, 140);
        }
    };


    public BankMainFrame(FrameConfig frameConfig) {
        super(frameConfig);
        constructFrame(NO_TITLE);
    }

    public BankMainFrame(FrameConfig frameConfig, String title){
        super(frameConfig);
        constructFrame(title);
    }


    @Override
    public Map<String, ButtonConfig> specifiesButtons() {
        Map<String, ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add personal account",new ButtonConfig(personalAccount,24,20,192,33));
        buttons.put("Add company account",new ButtonConfig(companyAccount,240,20,192,33));
        buttons.put("Withdraw",new ButtonConfig(withdraw,448,20,106,33));
        buttons.put("Deposit",new ButtonConfig(deposit,468,104,96,33));
        buttons.put("Add Interest",new ButtonConfig(addInterest,468,164,96,33));
        buttons.put("Exit",new ButtonConfig(getExitEventHandler(),468,248,96,31));
        return buttons;
    }

    @Override
    public void setAddAccountCommad(UICommand<UIBean> addAccountCommad) {
        this.addAccountCommand = addAccountCommad;
    }

    @Override
    public void setAddInterestCommand(UICommand<UIBean> addInterestCommand) {
        this.addInterestUICommand = addInterestCommand;
    }
}
