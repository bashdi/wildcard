package windows;

import gui.WildcardGui;

import javax.swing.*;

public class WildcardMainFrame extends JFrame implements WildcardGui {

    private JSplitPane jSplitPane;
    private DefaultListModel<String> defaultListModel;
    private JList<String> jList;

    public WildcardMainFrame() {
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        createSplitePane();
        add(jSplitPane);

        defaultListModel = new DefaultListModel<>();
        jList = new JList<>(defaultListModel);
        jSplitPane.setLeftComponent(jList);



        setVisible(true);
    }


    private void createSplitePane() {
        jSplitPane = new JSplitPane();
        jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.setDividerLocation(200);
    }

    @Override
    public JFrame getMainFrame() {
        return new WildcardMainFrame();
    }

    @Override
    public void addToList(String name, JPanel jPanel) {
        defaultListModel.addElement(name);
    }
}
