package org.miu.asd.banking;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.banking.ui.BankFrameConfig;
import org.miu.asd.banking.ui.BankMainFrame;
import org.miu.asd.banking.ui.BankMainFrameBuilder;
import org.miu.asd.banking.ui.command.AddAccountUICommand;
import org.miu.asd.banking.ui.command.AddInterestUICommand;
import org.miu.asd.banking.ui.command.ReportCreationUICommand;
import org.miu.asd.framework.dao.MemoryAccountDAO;
import org.miu.asd.framework.ui.command.DepositUICommand;
import org.miu.asd.framework.ui.command.FrameUpdateUICommand;
import org.miu.asd.framework.ui.command.WithdrawUICommand;


public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountService(new MemoryAccountDAO());
        BankMainFrame bankMainFrame = BankMainFrameBuilder.getInstance()
                .withTitle("Bank Application.")
                .withAccountService(bankAccountService)
                .withMainFrameConfig(new BankFrameConfig())
                .withAddAccountCommand(new AddAccountUICommand(bankAccountService))
                .withAddInterestCommand(new AddInterestUICommand(bankAccountService))
                .withAllAccReportCommand(new ReportCreationUICommand(bankAccountService))
                .withWithdrawCommand(new WithdrawUICommand(bankAccountService))
                .withFrameUpdateCommand(new FrameUpdateUICommand(bankAccountService))
                .withDepositCommand(new DepositUICommand(bankAccountService))
                .build();
        bankMainFrame.setVisible(true);
    }
}
