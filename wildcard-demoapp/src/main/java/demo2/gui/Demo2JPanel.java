package demo2.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Demo2JPanel extends JPanel {
    private JLabel headlineLabel;
    private JTextField nameTxtField;
    private JTextField punkteTxtField;
    private JPanel mainJPanel;
    private JButton addBtn;
    private JScrollPane scrollListJPane;
    private JList nameJList;
    private JButton addButton;
    private Vector<String> dataVector;


    public Demo2JPanel(){
        add(mainJPanel);
        dataVector = new Vector<>();
        nameJList.setListData(dataVector);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameTxtField.getText().isEmpty() && !punkteTxtField.getText().isEmpty()) {
                    dataVector.add(nameTxtField.getText() + " : " + punkteTxtField.getText());
                    nameJList.setListData(dataVector);
                }

            }
        });
        nameJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu tJpopupMenu = new JPopupMenu();
                    JMenuItem tMenuItem = new JMenuItem("delete");
                    tJpopupMenu.add(tMenuItem);
                    tMenuItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int[] indexList = nameJList.getSelectedIndices();

                            int tIndexCorrection = 0;
                            for(int item : indexList) {
                                dataVector.remove(item - tIndexCorrection++);
                            }
                            refreshList();
                        }
                    });
                    tJpopupMenu.show(nameJList, e.getX(), e.getY());
                }
            }
        });
    }

    private void refreshList() {
        nameJList.setListData(dataVector);
    }
}
