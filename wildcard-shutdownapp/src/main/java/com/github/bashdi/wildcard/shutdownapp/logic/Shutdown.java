package com.github.bashdi.wildcard.shutdownapp.logic;

public interface Shutdown {

    public boolean shutdown();

    public boolean shutdown(int seconds);

    public boolean cancelShutdown();
}
