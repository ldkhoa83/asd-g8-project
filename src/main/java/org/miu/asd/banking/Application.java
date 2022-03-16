package org.miu.asd.banking;

import org.miu.asd.banking.ui.BankMainFrame;
import org.miu.asd.banking.ui.BankMainFrameBuilder;


public class Application {
    public static void main(String[] args) {
        BankMainFrame bankMainFrame = BankMainFrameBuilder.getInstance().withTitle("").build();
        bankMainFrame.setVisible(true);
    }
}
