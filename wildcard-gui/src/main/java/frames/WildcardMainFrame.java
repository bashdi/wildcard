package frames;

import application.WildcardApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class WildcardMainFrame extends JFrame {

    private JSplitPane jSplitPane;
    private DefaultListModel<WildcardApplication> appList;
    private JList<WildcardApplication> jList;
    private JMenuBar wildcardMenuBar;

    public WildcardMainFrame() {
        setTitle("Wildcard");
        setIcon();
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        createMenuBar();

        createSplitePane();
        add(jSplitPane);

        appList = new DefaultListModel<>();
        jList = new JList<>(appList);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    WildcardApplication tApp = jList.getSelectedValue();
                    jSplitPane.setRightComponent(tApp.getGui());
                }

            }
        });
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



    private void createMenuBar() {
        wildcardMenuBar = new JMenuBar();
        JMenu tJmenu = new JMenu("Test");
        wildcardMenuBar.add(tJmenu);


        setJMenuBar(wildcardMenuBar);
    }



    public DefaultListModel<WildcardApplication> getAppList() {
        return appList;
    }



    public JMenuBar getWildcardMenuBar() {
        return wildcardMenuBar;
    }
}
