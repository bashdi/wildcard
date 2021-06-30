package application;

import gui.WildcardGuiManager;

import javax.swing.*;

public interface WildcardApplication {

    public String getName();

    public JPanel getPanel();

    public void post();

    public void setWildcardGuiManager(WildcardGuiManager wildcardGuiManager);

}
