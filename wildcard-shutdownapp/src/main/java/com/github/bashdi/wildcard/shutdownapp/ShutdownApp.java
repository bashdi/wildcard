package com.github.bashdi.wildcard.shutdownapp;

import application.WildcardApplication;
import com.github.bashdi.wildcard.shutdownapp.gui.ShutdownPanel;
import gui.WildcardGuiManager;

import javax.swing.*;

public class ShutdownApp implements WildcardApplication {

    WildcardGuiManager wildcardGuiManager;

    ShutdownPanel shutdownPanel;

    @Override
    public String getName() {
        return "Shutdown";
    }

    @Override
    public JPanel getPanel() {
        if (shutdownPanel == null) {
            shutdownPanel = new ShutdownPanel();
        }
        wildcardGuiManager.setTitle(getName());
        return shutdownPanel;
    }

    @Override
    public void post() {

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
