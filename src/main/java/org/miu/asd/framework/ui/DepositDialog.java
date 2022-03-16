package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.service.AccountService;

import javax.swing.*;
import java.awt.*;

public class DepositDialog extends JDialog
{
	private UICommand depositUICommand;
    
	public DepositDialog(FrameTemplate parent, String accountNumber, String customerName, AccountService accountService)
	{
		super(parent);
		depositUICommand = new DepositUICommand(accountService);

		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
	    JTextField_NAME.setText(accountNumber);
	    
		JButton_OK.addActionListener(e -> {
			UIBean bean = new UIBean();
			bean.setAmount(Double.valueOf(JTextField_Deposit.getText()));
			bean.setAccountNumber(accountNumber);
			Customer customer = new Customer(customerName,"","","","");
			bean.setCustomer(customer);
			depositUICommand.execute(bean);
			parent.updateContent();
			dispose();
		});
		JButton_Cancel.addActionListener(e -> dispose());
	}


	//{{DECLARE_CONTROLS
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_Deposit = new JTextField();
	//}}


}