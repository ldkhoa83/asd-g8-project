package org.miu.asd.creditcard.ui;
/*
		A basic implementation of the JDialog class.
*/

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.FrameTemplate;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

import javax.swing.*;
import java.awt.*;

public class JDialogGenBill extends JDialog
{
    String billstring;
	private UICommand billCreationUICommand;
	private String creditCardNumber;
    
	public JDialogGenBill(FrameTemplate parent, AccountService accountService, String creditCardNumber)
	{
		super(parent);
		billCreationUICommand = new BillCreationUICommand(accountService);
		this.creditCardNumber = creditCardNumber;
		
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill
		billstring = "Name= John White\r\n";
		billstring += "Address= 1000 Main, Fairfield, IA, 52556\r\n";
		billstring += "CC number= 2341 3421 4444 5689\r\n";
		billstring += "CC type= GOLD\r\n";
		billstring += "Previous balance = $ 100.00\r\n";
		billstring += "Total Credits = $ 25.00\r\n";
		billstring += "Total Charges = $ 560.00\r\n";
		billstring += "New balance = $ 638.75\r\n";
		billstring += "Total amount due = $ 63.88\r\n";		
		billstring += "\r\n";		
		billstring += "\r\n";		
		billstring += "Name= Frank Summer\r\n";
		billstring += "Address= 1000 N, 4th St, Fairfield, IA, 52556\r\n";
		billstring += "CC number= 0099 3421 4321 6577\r\n";
		billstring += "CC type= BRONZE\r\n";
		billstring += "Previous balance = $ 200.00\r\n";
		billstring += "Total Credits = $ 45.00\r\n";
		billstring += "Total Charges = $ 150.00\r\n";
		billstring += "New balance = $ 313.53\r\n";
		billstring += "Total amount due = $ 34.49\r\n";
		JTextField1.setText(billstring);

		CreditCardUIBean uiBean = new CreditCardUIBean();
		uiBean.setAccountNumber(creditCardNumber);
		this.billCreationUICommand.execute(uiBean);
		JTextField1.setText(uiBean.getMonthlyBillReport());
		//}}
	
		JButton_OK.addActionListener(e -> {
			dispose();
		});
	}


	//{{DECLARE_CONTROLS
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextField JTextField1 = new JTextField();
	JButton JButton_OK = new JButton();
	//}}


}
