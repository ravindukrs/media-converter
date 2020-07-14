package lk.kln.mit;

import lk.kln.mit.config.ConfigHandler;

public abstract class Converter extends Thread{

    protected ConfigHandler config = ConfigHandler.getInstance();

    protected abstract void encode();
    public abstract void run();
}
