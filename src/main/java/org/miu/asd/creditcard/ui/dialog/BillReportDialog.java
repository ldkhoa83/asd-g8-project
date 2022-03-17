package org.miu.asd.creditcard.ui.dialog;
/*
		A basic implementation of the JDialog class.
*/

import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.ui.FrameTemplate;
import org.miu.asd.framework.ui.command.UICommand;

import javax.swing.*;

public class BillReportDialog extends JDialog
{
	private UICommand<CreditCardUIBean> billCreationUICommand;

	public BillReportDialog(FrameTemplate parent, UICommand<CreditCardUIBean> uiCommand, String creditCardNumber)
	{
		super(parent);
		billCreationUICommand = uiCommand;

		initDialog(creditCardNumber);
	}

	private void initDialog(String creditCardNumber) {
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


		CreditCardUIBean uiBean = new CreditCardUIBean();
		uiBean.setAccountNumber(creditCardNumber);
		billCreationUICommand.execute(uiBean);
		JTextField1.setText(uiBean.getMonthlyBillReport());

		JButton_OK.addActionListener(e -> {
			dispose();
		});
	}


	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextField1 = new JTextArea();
	JButton JButton_OK = new JButton();

}
