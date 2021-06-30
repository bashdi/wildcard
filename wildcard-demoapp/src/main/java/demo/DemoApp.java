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
    public JPanel getPanel() {
        if (demoJPanel == null) {
            demoJPanel = new DemoJPanel(wildcardGuiManager);
        }
        wildcardGuiManager.setTitle(getName());
        return demoJPanel;
    }

    @Override
    public void post() {
        wildcardGuiManager.setTitle(null);
        wildcardGuiManager.clearMenuBar();
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
