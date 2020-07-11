package lk.kln.mit;

import ws.schild.jave.*;

import java.io.File;

public class MP3Converter extends Thread {

    private int x = (int) (Math.random()*100);
    private String path="MediaContent/Source/MP4toMP3/videoplayback.mp4";
    private String pathmp3="MediaContent/Target/MP4toMP3Converted/output10"+x+".mp3";

    public MP3Converter(){}

    public MP3Converter(String path, String pathmp3){
        this.path = path;
        this.pathmp3 = pathmp3;
    }


    public void run(){
        File video= new File(path);
        File target = new File(pathmp3);

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

}
