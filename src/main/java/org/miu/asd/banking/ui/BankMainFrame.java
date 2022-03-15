package org.miu.asd.banking.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankMainFrame extends FrameTemplate{

    private final ActionListener personalAccount = (actionEvent) -> {
        openDialog(new AddPersonalAccDialog(this,getAccountService()));
    };
    private final ActionListener companyAccount = (actionEvent) -> {
        openDialog(new AddCompanyAccountDialog(this,getAccountService()));
    };
    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new DepositDialog(this, accnr, getAccountService()),430, 15, 275, 140);
        }
    };
    private final ActionListener addInterest = (actionEvent) -> {
        //Add interestCommand
        JOptionPane.showMessageDialog(null, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    };
    private final ActionListener withdraw = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0){
            String accnr = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new WithdrawDialog(this, accnr, getAccountService()),430, 15, 275, 140);
        }
    };


    public BankMainFrame(AccountService accountService, FrameConfig frameConfig) {
        super(accountService, frameConfig);
        init("No Title");
    }

    public BankMainFrame(AccountService accountService, FrameConfig frameConfig, String title){
        super(accountService, frameConfig);
        init(title);
    }


    @Override
    public void init(String title) {
        Map<String, ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add personal account",new ButtonConfig(personalAccount,24,20,192,33));
        buttons.put("Add company account",new ButtonConfig(companyAccount,240,20,192,33));
        buttons.put("Withdraw",new ButtonConfig(withdraw,448,20,106,33));
        buttons.put("Deposit",new ButtonConfig(deposit,468,104,96,33));
        buttons.put("Add Interest",new ButtonConfig(addInterest,468,164,96,33));
        buttons.put("Exit",new ButtonConfig(getExitEventHandler(),468,248,96,31));
        constructFrame(title,buttons);
    }

}
