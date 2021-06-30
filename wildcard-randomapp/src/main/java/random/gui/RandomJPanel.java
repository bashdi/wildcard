package random.gui;

import gui.WildcardGuiManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomJPanel extends JPanel {
    private JPanel rootPanel;
    private JTextField txtInput;
    private JButton btnRandom;

    private WildcardGuiManager wildcardGuiManager;

    public RandomJPanel(WildcardGuiManager wildcardGuiManager) {
        this.wildcardGuiManager = wildcardGuiManager;
        add(rootPanel);
        btnRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tInput = txtInput.getText();
                char[] tCharArray = tInput.toCharArray();
                if (tCharArray.length == 0) return;

                for (int i = 1; i <= 20; i++) {
                    int tRandomInt1 = ((int)(Math.random() * tCharArray.length));
                    int tRandomInt2 = ((int)(Math.random() * tCharArray.length));

                    char tChar1 = tCharArray[tRandomInt1];
                    tCharArray[tRandomInt1] = tCharArray[tRandomInt2];
                    tCharArray[tRandomInt2] = tChar1;
                }


                txtInput.setText(String.copyValueOf(tCharArray));
            }
        });
    }
}
