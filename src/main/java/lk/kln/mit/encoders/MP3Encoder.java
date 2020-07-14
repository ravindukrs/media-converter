package lk.kln.mit.encoders;

import lk.kln.mit.ConvertProgressListener;
import lk.kln.mit.Converter;
import ws.schild.jave.*;

import java.io.File;

public class MP3Encoder extends Converter {

    private int x = (int) (Math.random()*100);
    private String path= config.getPath("source.mp3");
    private String destinationPath= config.getPath("destination.mp3");
    private String fileName = null;

    public MP3Encoder(){}

    public MP3Encoder(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void encode() {
        File video= new File(path+fileName);
        File target = new File(destinationPath+fileName+".mp3");

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
