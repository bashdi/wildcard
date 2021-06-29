import frames.WildcardMainFrame;
import gui.WildcardGuiManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultGuiManager implements WildcardGuiManager {

    WildcardMainFrame wildcardMainFrame;

    List<JMenu> menuList;
    final String APP_NAME = "Wildcard";

    public DefaultGuiManager(WildcardMainFrame wildcardMainFrame) {
        this.wildcardMainFrame = wildcardMainFrame;
        menuList = new ArrayList<>();
    }



    @Override
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            wildcardMainFrame.setTitle(APP_NAME);
        } else {
            wildcardMainFrame.setTitle(APP_NAME + " - " + title);
        }
    }



    @Override
    public void addToMenuBar(JMenu jMenu) {
        if (menuList.contains(jMenu)) {
            return;
        }
        wildcardMainFrame.getWildcardMenuBar().add(jMenu);
        menuList.add(jMenu);
        wildcardMainFrame.getWildcardMenuBar().revalidate();
        wildcardMainFrame.repaint();
    }



    @Override
    public void clearMenuBar() {
        menuList.forEach(m -> {
            wildcardMainFrame.getWildcardMenuBar().remove(m);
        });
        menuList.clear();
        wildcardMainFrame.repaint();
    }
}
