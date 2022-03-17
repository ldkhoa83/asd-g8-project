package org.miu.asd.banking.ui;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.banking.ui.command.AddAccountUICommand;
import org.miu.asd.banking.ui.command.AddInterestUICommand;
import org.miu.asd.banking.ui.command.ReportCreationUICommand;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.*;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.DepositUICommand;
import org.miu.asd.framework.ui.command.FrameUpdateUICommand;
import org.miu.asd.framework.ui.command.UICommand;
import org.miu.asd.framework.ui.command.WithdrawUICommand;

public class BankMainFrameBuilder {
    private static final BankMainFrameBuilder INSTANCE = new BankMainFrameBuilder();

    private static AccountService accountService = new BankAccountService(new MemoryAccountDAO());
    private static BankMainFrameConfig mainFrameConfig = new BankMainFrameConfig();
    private static UICommand<BaseUIBean> addAccountUICommand = new AddAccountUICommand(accountService);
    private static UICommand<BaseUIBean> frameUpdateUICommand = new FrameUpdateUICommand(accountService);
    private static UICommand<BaseUIBean> depositUICommand = new DepositUICommand(accountService);
    private static UICommand<BaseUIBean> withdrawUICommand = new WithdrawUICommand(accountService);
    private static UICommand<BaseUIBean> addInterestUICommand = new AddInterestUICommand(accountService);
    private static UICommand<BaseUIBean> generateAllAccReportsUICommand = new ReportCreationUICommand(accountService);
    private static String frameTitle = FrameTemplate.NO_TITLE;

    private BankMainFrameBuilder(){}

    public static BankMainFrameBuilder getInstance(){
        return INSTANCE;
    }

    public BankMainFrameBuilder withAccountService(AccountService service){
        accountService = service;
        return INSTANCE;
    }

    public BankMainFrameBuilder withFrameUpdateCommand(UICommand<BaseUIBean> frameUpdateCommand){
        frameUpdateUICommand = frameUpdateCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withDepositCommand(UICommand<BaseUIBean> depositCommand){
        depositUICommand = depositCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddAccountCommand(UICommand<BaseUIBean> addAccountCommand){
        addAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withWithdrawCommand(UICommand<BaseUIBean> withdrawCommand){
        withdrawUICommand = withdrawCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddInterestCommand(UICommand<BaseUIBean> addInterestCommand){
        addInterestUICommand = addInterestCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAllAccReportCommand(UICommand<BaseUIBean> allAccReportCommand){
        generateAllAccReportsUICommand = allAccReportCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withMainFrameConfig(BankMainFrameConfig bankMainFrameConfig){
        mainFrameConfig = bankMainFrameConfig;
        return INSTANCE;
    }

    public BankMainFrameBuilder withTitle(String title){
        frameTitle = title;
        return INSTANCE;
    }

    public BankMainFrame build(){
        BankMainFrame bankMainFrame = new BankMainFrame(mainFrameConfig,frameTitle);
        bankMainFrame.setAddAccountCommad(addAccountUICommand);
        bankMainFrame.setFrameUpdateCommand(frameUpdateUICommand);
        bankMainFrame.setDepositCommand(depositUICommand);
        bankMainFrame.setWithdrawCommand(withdrawUICommand);
        bankMainFrame.setAddInterestCommand(addInterestUICommand);
        bankMainFrame.setAllAccReportCommand(generateAllAccReportsUICommand);

        return bankMainFrame;
    }
}
