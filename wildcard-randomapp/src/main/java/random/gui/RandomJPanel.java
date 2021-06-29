package random.gui;

import gui.WildcardGuiManager;

import javax.swing.*;

public class RandomJPanel extends JPanel {
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton button1;

    private WildcardGuiManager wildcardGuiManager;

    public RandomJPanel(WildcardGuiManager wildcardGuiManager) {
        this.wildcardGuiManager = wildcardGuiManager;
        add(rootPanel);
    }
}
