package lk.kln.mit;

import lk.kln.mit.config.ConfigHandler;
import lk.kln.mit.watchers.FLVWatcher;
import lk.kln.mit.watchers.MKVWatcher;
import lk.kln.mit.watchers.MP3Watcher;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.OFF);

        //MediaConverter mediaConverter = new MediaConverter();
        //mediaConverter.convertToMp3("MediaContent/Source/MP4toMP3/videoplayback.mp4", "MediaContent/Target/MP4toMPConverted/output10.mp3");
//        MP3Converter mp3Converter1 = new MP3Converter();
//        mp3Converter1.start();
//
//        MP3Converter mp3Converter2 = new MP3Converter();
//        mp3Converter2.start();
//
//        MP3Converter mp3Converter3 = new MP3Converter();
//        mp3Converter3.start();

//        MP3Encoder mp3Converter1 = new MP3Encoder();
//        mp3Converter1.start();


//        MediaConverterFactory converterFactory = new MediaConverterFactory();
//
//        Converter mp3Converter = converterFactory.getConverter("MP3");
//        Converter flvConverter = converterFactory.getConverter("FLV");
//        Converter mkvConverter = converterFactory.getConverter("MKV");
//
//        mp3Converter.start(); //Cannot call start method here
//        flvConverter.start(); //Cannot call start method here
//        mkvConverter.start(); //Cannot call start method here


//        MKVEncoder mkvConverter2 = new MKVEncoder();
//        mkvConverter2.start();

//        ConfigHandler configHandler = ConfigHandler.getInstance();
//        System.out.println(configHandler.getPath("source.mp3"));

        MP3Watcher mp3Watcher = MP3Watcher.getInstance();
        mp3Watcher.start();
        FLVWatcher flvWatcher = FLVWatcher.getInstance();
        flvWatcher.start();
        MKVWatcher mkvWatcher = MKVWatcher.getInstance();
        mkvWatcher.start();


    }
}
