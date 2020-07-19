package lk.kln.mit;

import lk.kln.mit.config.ConfigHandler;
import lk.kln.mit.watchers.FLVWatcher;
import lk.kln.mit.watchers.MKVWatcher;
import lk.kln.mit.watchers.MP3Watcher;
import lk.kln.mit.StartConvert;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        //Turn off Logger (For release build)
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.OFF);


        StartConvert.startConvert();

    }
}
