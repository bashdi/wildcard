import com.github.bashdi.wildcard.shutdownapp.ShutdownApp;
import demo.DemoApp;
import demo2.Demo2App;
import random.RandomApp;

public class Main {

    public static void main(String[] args) {

        WildcardGui wildcardGui = new WildcardGui();
        wildcardGui.addWildcardApplication(new DemoApp());
        wildcardGui.addWildcardApplication(new Demo2App());
        wildcardGui.addWildcardApplication(new RandomApp());
        wildcardGui.addWildcardApplication(new ShutdownApp());
    }
}
