import demo.DemoApp;
import random.RandomApp;

public class Main {

    public static void main(String[] args) {
        WildcardGui wildcardGui = new WildcardGui();
        wildcardGui.addWildcardApplication(new DemoApp());
        wildcardGui.addWildcardApplication(new RandomApp());
    }
}
