package demo;

import application.WildcardApplication;
import demo.gui.DemoJPanel;
import gui.WildcardGuiManager;

import javax.swing.*;

public class DemoApp implements WildcardApplication {

    WildcardGuiManager wildcardGuiManager;

    static JPanel demoJPanel;

    @Override
    public String getName() {
        return "DemoApp";
    }

    @Override
    public JPanel getGui() {
        if (demoJPanel == null) {
            demoJPanel = new DemoJPanel(wildcardGuiManager);
        }
        return demoJPanel;
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
