package lk.kln.mit.encoders;

import lk.kln.mit.ConvertProgressListener;
import lk.kln.mit.Converter;
import ws.schild.jave.*;

import java.io.File;

public class MP3Encoder extends Converter {

    private int x = (int) (Math.random()*100);
    private String path="MediaContent/Source/MP4toMP3/videoplayback.mp4";
    private String destinationPath="MediaContent/Target/MP4toMP3Converted/output10"+x+".mp3";

    public MP3Encoder(){}

    public MP3Encoder(String path, String destinationPath){
        this.path = path;
        this.destinationPath = destinationPath;
    }

    @Override
    public void encode() {
        File video= new File(path);
        File target = new File(destinationPath);

        ConvertProgressListener listener = new ConvertProgressListener(video);

        AudioAttributes audio = new AudioAttributes();

        audio.setCodec("libmp3lame");
        audio.setBitRate(28000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);

        Encoder encoder = new Encoder();
        try {
            encoder.encode(new MultimediaObject(video), target, attrs, listener);
        } catch (
                EncoderException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        encode();
    }
}
