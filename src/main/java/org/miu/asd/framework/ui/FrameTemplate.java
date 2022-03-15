package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.service.AccountService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

public abstract class FrameTemplate extends JFrame {
    JPanel JPanel1 = new JPanel();

    protected FrameConfig frameConfig;
    boolean newaccount = false;
    private DefaultTableModel model;
    protected JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object rowdata[];

    private AccountService accountService;

    public FrameTemplate(AccountService accountService,FrameConfig frameConfig){
        this.accountService = accountService;
        this.frameConfig = frameConfig;
        addWindowListener(new SymWindow());
    }

    public abstract void init(String title);

    protected final void constructFrame(String title, Map<String, ButtonConfig> buttons){
        setupMainPanel(title,frameConfig);
        setupContentGrid(frameConfig);
        setupButtons(buttons);
    }

    private void setupButtons(Map<String, ButtonConfig> buttons) {
        for(Map.Entry<String,ButtonConfig> button : buttons.entrySet()){
            JButton btn = new JButton();
            btn.setText(button.getKey());
            JPanel1.add(btn);
            btn.addActionListener(button.getValue().getActionListener());
            btn.setBounds(button.getValue().getX(),button.getValue().getY(),button.getValue().getWidth(),button.getValue().getHeight());
        }
    }

    private void setupContentGrid(FrameConfig frameConfig) {
        JScrollPane1 = new JScrollPane();

        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        for(String columnName : frameConfig.getColumnsOfContentGrid()){
            model.addColumn(columnName);
        }
        rowdata = new Object[frameConfig.getColumnsOfContentGrid().size()];

        JScrollPane1.setBounds(12,92,frameConfig.getContentScrollPanelWidth(),frameConfig.getContentScrollPanelHeight());
        JPanel1.add(JScrollPane1);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, frameConfig.getContentGridWith(), frameConfig.getContentGridHeight());
    }

    private void setupMainPanel(String title, FrameConfig frameConfig) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(frameConfig.getFrameWith(),frameConfig.getFrameHeight());
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,frameConfig.getFrameWith(),frameConfig.getFrameHeight());
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void openDialog(JDialog jDialog){
        openDialog(jDialog, 450, 20, 300, 330);
    }

    public void openDialog(JDialog jDialog, int x, int y, int width, int height){
        jDialog.setBounds(x, y, width, height);
        jDialog.show();
    }

    protected final ActionListener exit = (ActionListener) -> {
        System.exit(0);
    };

    public AccountService getAccountService() {
        return accountService;
    }

    public void updateContent() {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
//        accountService.getAllAccounts().forEach(this::tableRow);
    }

    private void tableRow(Account account){
        model.addRow(frameConfig.buildRow(account));
        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
    }

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    public int getSelectionIndex() {
        return JTable1.getSelectionModel().getMinSelectionIndex();
    }

    public ActionListener getExitEventHandler() {
        return exit;
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            Object object = event.getSource();
            if (object instanceof FrameTemplate)
                MainFrm_windowClosing(event);
        }
    }

    void MainFrm_windowClosing(WindowEvent event)
    {
        // to do: code goes here.
        MainFrm_windowClosing_Interaction1(event);
    }

    void MainFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    public static class ButtonConfig {
        private ActionListener actionListener;
        private int x;
        private int y;
        private int width;
        private int height;

        public ButtonConfig(ActionListener actionListener, int x, int y, int width, int height) {
            this.actionListener = actionListener;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public ActionListener getActionListener() {
            return actionListener;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
