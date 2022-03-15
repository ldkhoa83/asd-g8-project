package org.miu.asd.framework.ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public abstract class FormTemplate extends JFrame {

    public void constructMainForm(String title, FormConfig formConfig, Map<String, ActionListener> buttonCommands){
        setupMainPanel();

    }
}
