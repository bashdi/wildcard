import application.WildcardApplication;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import frames.WildcardMainFrame;
import gui.WildcardGuiManager;

import javax.swing.*;

public class WildcardGui {

    WildcardMainFrame wildcardMainFrame;
    WildcardGuiManager wildcardGuiManager;

    public WildcardGui() {
        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        wildcardMainFrame = new WildcardMainFrame();
        wildcardGuiManager = new DefaultGuiManager(wildcardMainFrame);
    }


    public void addWildcardApplication(WildcardApplication wildcardApplication) {
        wildcardApplication.setWildcardGuiManager(wildcardGuiManager);
        wildcardMainFrame.getAppList().addElement(wildcardApplication);
    }
}
