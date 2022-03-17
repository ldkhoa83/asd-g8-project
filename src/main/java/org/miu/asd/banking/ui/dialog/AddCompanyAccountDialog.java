package org.miu.asd.banking.ui.dialog;

import org.miu.asd.framework.domain.Company;
import org.miu.asd.banking.ui.AccountType;
import org.miu.asd.framework.ui.FrameTemplate;
import org.miu.asd.framework.ui.bean.UIBean;
import org.miu.asd.framework.ui.command.UICommand;

import javax.swing.*;
import java.awt.*;



public class AddCompanyAccountDialog extends JDialog
{
	private UICommand addCompAccountUICommand;

	public AddCompanyAccountDialog(FrameTemplate parent, UICommand addAccountUICommand)
	{
		super(parent);
		addCompAccountUICommand = addAccountUICommand;

		initDialog(parent);
	}

	private void initDialog(FrameTemplate parent) {
		setTitle("Add company account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,339);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,96,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,120,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,144,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,168,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,192,48,24);
		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,216,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,240,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120,96,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120,144,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120,168,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120,120,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120,192,156,20);
		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,216,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120,240,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,276,84,24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156,276,84,24);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,72,48,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120,72,156,20);

		JButton_OK.addActionListener(e -> {
			UIBean bean = new UIBean();

			String accNum = JTextField_ACNR.getText();
			String name =JTextField_NAME.getText();
			String street=JTextField_STR.getText();
			String city=JTextField_CT.getText();
			String zip=JTextField_ZIP.getText();
			String state=JTextField_ST.getText();
			Integer numOfEmployees = Integer.valueOf(JTextField_NoOfEmp.getText());

			bean.setCustomer(new Company(name,street,city,state,zip,numOfEmployees));
			bean.setAccountNumber(accNum);

			String accountType;
			if (JRadioButton_Chk.isSelected())
				accountType= AccountType.CHECKING.getName();
			else
				accountType= AccountType.SAVING.getName();
			bean.setAccountType(accountType);
			addCompAccountUICommand.execute(bean);
			parent.updateContent();
			dispose();
		});
		JButton_Calcel.addActionListener(e -> dispose());
	}


	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_NoOfEmp = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Calcel = new JButton();
	JLabel JLabel8 = new JLabel();
	JTextField JTextField_ACNR = new JTextField();


}