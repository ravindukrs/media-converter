package lk.kln.mit;

import lk.kln.mit.config.ConfigHandler;

public class Watcher extends Thread {
    protected ConfigHandler config = ConfigHandler.getInstance();
    protected MediaConverterFactory converterFactory = new MediaConverterFactory();
}
