package lk.kln.mit;

import ws.schild.jave.*;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path="MediaContent/Source/videoplayback.mp4";
        String pathpm3="MediaContent/Target/output2.mp3";

        File video= new File(path);

        File target = new File(pathpm3);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);

        Encoder encoder = new Encoder();
        try {
            encoder.encode(new MultimediaObject(video), target, attrs);
        } catch (EncoderException e) {
            e.printStackTrace();
        }


    }
}
