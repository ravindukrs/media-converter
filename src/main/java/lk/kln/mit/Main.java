package lk.kln.mit;

import lk.kln.mit.encoders.FLVEncoder;
import lk.kln.mit.encoders.MKVEncoder;
import lk.kln.mit.encoders.MP3Encoder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ws.schild.jave.*;

import java.io.File;
import java.util.List;

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

        FLVEncoder mkvConv = new FLVEncoder();
        mkvConv.start();



    }
}
