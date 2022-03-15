package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.FrameTemplate;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

import javax.swing.*;
import java.awt.*;

public class ChargeDialog extends JDialog {
    private FrameTemplate parentframe;
    private String creditCardNumber;
    private UICommand chargeUICommand;

    public ChargeDialog(CreditCardMainFrame parent, String creditCardNumber, AccountService accountService) {

        super(parent);
        parentframe=parent;
        this.creditCardNumber =creditCardNumber;
        chargeUICommand = new ChargeUICommand(accountService);

        setTitle("Charge");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(277,134);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12,12,48,24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(Color.black);
        JLabel2.setBounds(12,36,48,24);
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,12,156,20);
        getContentPane().add(JTextField_AMT);
        JTextField_AMT.setBounds(84,36,156,20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,84,84,24);
        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        getContentPane().add(JButton_Calcel);
        JButton_Calcel.setBounds(156,84,84,24);

        JTextField_NAME.setText(this.creditCardNumber);


        JButton_OK.addActionListener(e -> {
            UIBean bean = new UIBean();
            bean.setAmount(Double.valueOf(JTextField_AMT.getText()));
            bean.setAccountNumber(creditCardNumber);
            chargeUICommand.execute(bean);
            parentframe.updateContent();
            dispose();
        });
        JButton_Calcel.addActionListener(e -> dispose());

    }

    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_AMT = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Calcel = new JButton();
}
