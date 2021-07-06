package demo2;

import application.WildcardApplication;
import demo2.gui.Demo2JPanel;
import gui.WildcardGuiManager;

import javax.swing.*;

public class Demo2App implements WildcardApplication {

    WildcardGuiManager wildcardGuiManager;
    JPanel jPanel;

    @Override
    public String getName() {
        return "Demo2App";
    }

    @Override
    public JPanel getPanel() {
        if (jPanel == null) {
            jPanel = new Demo2JPanel();
        }
        wildcardGuiManager.setTitle(getName());
        return jPanel;
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
