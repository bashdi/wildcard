package windows;

import gui.WildcardGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WildcardMainFrame extends JFrame implements WildcardGui {

    private JSplitPane jSplitPane;
    private DefaultListModel<String> defaultListModel;
    private JList<String> jList;

    public WildcardMainFrame() {
        setIcon();
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



    private void setIcon() {
        try {
            Image tImage = ImageIO.read(ClassLoader.getSystemResource("wildcard.png"));
            setIconImage(tImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
