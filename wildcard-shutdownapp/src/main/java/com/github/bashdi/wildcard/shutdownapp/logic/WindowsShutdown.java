package com.github.bashdi.wildcard.shutdownapp.logic;

import com.github.bashdi.wildcard.commons.utilities.ShellCommand;

public class WindowsShutdown implements Shutdown{

    private static final String SHUTDOWN_CMD = "shutdown -s -f -t %d";
    private static final String SHUTDOWN_CANCEL_CMD = "shutdown -a";

    @Override
    public boolean shutdown() {
        return shutdown(60);
    }

    @Override
    public boolean shutdown(int seconds) {
        return ShellCommand.execute(String.format(SHUTDOWN_CMD, seconds));
    }

    @Override
    public boolean cancelShutdown() {
        return ShellCommand.execute(SHUTDOWN_CANCEL_CMD);
    }
}
