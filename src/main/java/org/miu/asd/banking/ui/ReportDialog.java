package org.miu.asd.banking.ui;
/*
		A basic implementation of the JDialog class.
*/

import org.miu.asd.creditcard.ui.CreditCardUIBean;
import org.miu.asd.framework.ui.FrameTemplate;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

import javax.swing.*;

public class ReportDialog extends JDialog
{
	private UICommand<UIBean> reportUICommand;

	public ReportDialog(FrameTemplate parent, UICommand<UIBean> uiCommand)
	{
		super(parent);
		reportUICommand = uiCommand;

		initDialog();
	}

	private void initDialog() {
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


		UIBean uiBean = new UIBean();
		reportUICommand.execute(uiBean);
		JTextField1.setText(uiBean.getAllAccountsReport());

		JButton_OK.addActionListener(e -> {
			dispose();
		});
	}


	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextField1 = new JTextArea();
	JButton JButton_OK = new JButton();

}
