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
        return "Randomizer";
    }

    @Override
    public JPanel getPanel() {
        if (jPanel == null) {
            jPanel = new RandomJPanel(wildcardGuiManager);
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
