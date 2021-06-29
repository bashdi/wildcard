package application;

import gui.WildcardGuiManager;

import javax.swing.*;

public interface WildcardApplication {

    public String getName();

    public JPanel getGui();

    public void setWildcardGuiManager(WildcardGuiManager wildcardGuiManager);

}
