package demo.gui;

import gui.WildcardGuiManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoJPanel extends JPanel {

    WildcardGuiManager wildcardGuiManager;

    JMenu jMenu;
    JMenuItem item1, item2, item3;

    public DemoJPanel(WildcardGuiManager wildcardGuiManager) {
        this.wildcardGuiManager = wildcardGuiManager;

        wildcardGuiManager.setTitle("DemoApp");

        createMenu();
        wildcardGuiManager.addToMenuBar(jMenu);

        JButton button1 = new JButton("ClearMenu");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wildcardGuiManager.clearMenuBar();
            }
        });
        add(button1);

        JButton button2 = new JButton("AddMenu");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wildcardGuiManager.addToMenuBar(jMenu);
            }
        });
        add(button2);

    }

    private void createMenu() {
        jMenu = new JMenu("DemoApp");
        item1 = new JMenuItem("Settings");
        item2 = new JMenuItem("Info");
        item3 = new JMenuItem("Website");
        jMenu.add(item1);
        jMenu.add(item2);
        jMenu.add(item3);
    }


    public JMenu getjMenu() {
        return jMenu;
    }
}
