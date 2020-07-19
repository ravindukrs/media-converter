package lk.kln.mit;

import lk.kln.mit.config.ConfigHandler;

public class Watcher extends Thread {
    //config: To get file paths for child classes
    protected ConfigHandler config = ConfigHandler.getInstance();
    //converterFactory: to instantiate new encoders in child classes
    protected MediaConverterFactory converterFactory = new MediaConverterFactory();
}
