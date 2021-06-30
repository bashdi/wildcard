package frames;

import application.WildcardApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WildcardMainFrame extends JFrame {

    private JSplitPane jSplitPane;
    private DefaultListModel<WildcardApplication> appList;
    private JList<WildcardApplication> jList;
    private JMenuBar wildcardMenuBar;
    private final String FRAME_TITLE = "Wildcard";
    private WildcardApplication previousApp;




    public WildcardMainFrame() {
        setTitle(FRAME_TITLE);
        setIcon();
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        createMenuBar();

        createSplitePane();
        add(jSplitPane);

        appList = new DefaultListModel<>();
        jList = new JList<>(appList);
        jList.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                if (previousApp != null) {
                    previousApp.post();
                }
                WildcardApplication tApp = jList.getSelectedValue();
                previousApp = tApp;
                jSplitPane.setRightComponent(tApp.getPanel());
            }
        });
        JScrollPane tJScrollPane = new JScrollPane();
        tJScrollPane.setViewportView(jList);
        jSplitPane.setLeftComponent(tJScrollPane);



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
