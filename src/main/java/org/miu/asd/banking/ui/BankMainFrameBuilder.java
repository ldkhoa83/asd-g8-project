package org.miu.asd.banking.ui;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.*;

public class BankMainFrameBuilder {
    private static final BankMainFrameBuilder INSTANCE = new BankMainFrameBuilder();

    private static AccountService accountService = new BankAccountService(new MemoryAccountDAO());
    private static BankMainFrameConfig mainFrameConfig = new BankMainFrameConfig();
    private static UICommand<UIBean> addAccountUICommand = new AddAccountUICommand(accountService);
    private static UICommand<UIBean> frameUpdateUICommand = new FrameUpdateUICommand(accountService);
    private static UICommand<UIBean> depositUICommand = new DepositUICommand(accountService);
    private static UICommand<UIBean> withdrawUICommand = new WithdrawUICommand(accountService);
    private static UICommand<UIBean> addInterestUICommand = new AddInterestUICommand(accountService);
    private static String frameTitle = FrameTemplate.NO_TITLE;

    private BankMainFrameBuilder(){}

    public static BankMainFrameBuilder getInstance(){
        return INSTANCE;
    }

    public BankMainFrameBuilder withAccountService(AccountService service){
        accountService = service;
        return INSTANCE;
    }

    public BankMainFrameBuilder withFrameUpdateCommand(UICommand<UIBean> frameUpdateCommand){
        frameUpdateUICommand = frameUpdateCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withDepositCommand(UICommand<UIBean> depositCommand){
        depositUICommand = depositCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddAccountCommand(UICommand<UIBean> addAccountCommand){
        addAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withWithdrawCommand(UICommand<UIBean> withdrawCommand){
        withdrawUICommand = withdrawCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddInterestCommand(UICommand<UIBean> addInterestCommand){
        addInterestUICommand = addInterestCommand;
        return INSTANCE;
    }

    public static BankMainFrameBuilder withMainFrameConfig(BankMainFrameConfig bankMainFrameConfig){
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

        return bankMainFrame;
    }
}
