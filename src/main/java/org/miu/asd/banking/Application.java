package org.miu.asd.banking;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.banking.ui.BankMainFrame;
import org.miu.asd.banking.ui.BankMainFrameBuilder;
import org.miu.asd.framework.dao.MemoryAccountDAO;


public class Application {
    public static void main(String[] args) {
        BankMainFrame bankMainFrame = BankMainFrameBuilder.getInstance()
                .withTitle("Bank Application.")
                .build();
        bankMainFrame.setVisible(true);
    }
}
