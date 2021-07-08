package com.github.bashdi.wildcard.commons.utilities;

import java.io.IOException;

public class ShellCommand {

    public static boolean execute(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
