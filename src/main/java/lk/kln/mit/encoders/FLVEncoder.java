package lk.kln.mit.encoders;

import lk.kln.mit.ConvertProgressListener;
import lk.kln.mit.Converter;
import ws.schild.jave.*;

import java.io.File;

public class FLVEncoder extends Thread implements Converter {

    private int x = (int) (Math.random()*100);
    private String path="MediaContent/Source/MP4toFLV/videoplayback.mp4";
    private String destinationPath="MediaContent/Target/MP4toFLVConverted/output10"+x+".flv";

    public FLVEncoder(){}

    public FLVEncoder(String path, String destinationPath){
        this.path = path;
        this.destinationPath = destinationPath;
    }

    @Override
    public void encode() {

        File videoFile= new File(path);
        File target = new File(destinationPath);

        ConvertProgressListener listener = new ConvertProgressListener(videoFile);

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac");
// here 64kbit/s is 64000
        audio.setBitRate(64000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);

        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264");
        video.setX264Profile(VideoAttributes.X264_PROFILE.BASELINE);
        video.setBitRate(640000);
        video.setFrameRate(30);
        video.setSize(new VideoSize(1280, 720));

        /* Step 4. Set Encoding Attributes*/
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("flv");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        try {
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(videoFile), target, attrs, listener);
        } catch (Exception e) {
            /*Handle here the video failure*/
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        encode();
    }
}
