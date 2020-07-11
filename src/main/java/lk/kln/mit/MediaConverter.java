package lk.kln.mit;

import ws.schild.jave.*;

import java.io.File;

public class MediaConverter {


    private static String path="MediaContent/Source/MP4toMP3/videoplayback.mp4";
    private static String pathpm3="MediaContent/Target/MP4toMPConverted/output10.mp3";

    public void convertToMp3(String path, String pathmp3){

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
