package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

public abstract class FrameTemplate extends JFrame implements UICommandController{
    protected FrameConfig<Account> frameConfig;

    JPanel JPanel1 = new JPanel();
    private DefaultTableModel model;
    protected JTable JTable1;
    private JScrollPane JScrollPane1;

    public static final String NO_TITLE = "No Title.";

    private UICommand<BaseUIBean> frameUpdateCommand;
    private UICommand<BaseUIBean> depositCommand;
    private UICommand<BaseUIBean> withdrawCommand;

   public FrameTemplate(FrameConfig<Account> frameConfig){
        this.frameConfig = frameConfig;
        addWindowListener(new SymWindow());
    }

    public abstract Map<String, ButtonConfig> specifiesButtons();

    public final void constructFrame(String title){
        setupMainPanel(title,frameConfig);
        setupContentGrid(frameConfig);
        setupButtons(specifiesButtons());
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

    private void setupContentGrid(FrameConfig<Account> frameConfig) {
        JScrollPane1 = new JScrollPane();

        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        for(String columnName : frameConfig.getColumnsOfContentGrid()){
            model.addColumn(columnName);
        }
        JScrollPane1.setBounds(12,92,frameConfig.getContentScrollPanelWidth(),frameConfig.getContentScrollPanelHeight());
        JPanel1.add(JScrollPane1);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, frameConfig.getContentGridWith(), frameConfig.getContentGridHeight());
    }

    private void setupMainPanel(String title, FrameConfig<Account> frameConfig) {
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

    public void updateContent() {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        BaseUIBean bean = new BaseUIBean();
        frameUpdateCommand.execute(bean);
        bean.getAllAccounts().forEach(this::tableRow);
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
        MainFrm_windowClosing_Interaction1(event);
    }

    void MainFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    @Override
    public void setFrameUpdateCommand(UICommand<BaseUIBean> frameUpdateCommand) {
        this.frameUpdateCommand = frameUpdateCommand;
    }

    @Override
    public void setDepositCommand(UICommand<BaseUIBean> depositUICommand) {
        this.depositCommand = depositUICommand;
    }

    @Override
    public void setWithdrawCommand(UICommand<BaseUIBean> withdrawUICommand) {
        this.withdrawCommand = withdrawUICommand;
    }


    protected UICommand<BaseUIBean> getDepositCommand() {
        return depositCommand;
    }

    protected UICommand<BaseUIBean> getWithdrawCommand() {
        return withdrawCommand;
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
