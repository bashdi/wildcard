package random;

import application.WildcardApplication;
import gui.WildcardGuiManager;
import random.gui.RandomJPanel;

import javax.swing.*;

public class RandomApp implements WildcardApplication {

    WildcardGuiManager wildcardGuiManager;

    static JPanel jPanel;

    @Override
    public String getName() {
        return "RandomApp";
    }

    @Override
    public JPanel getGui() {
        if (jPanel == null) {
            jPanel = new RandomJPanel(wildcardGuiManager);
        }
        return jPanel;
    }

    @Override
    public void setWildcardGuiManager(WildcardGuiManager wildcardGuiManager) {
        this.wildcardGuiManager = wildcardGuiManager;
    }

    @Override
    public String toString() {
        return getName();
    }
}
