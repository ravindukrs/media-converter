package lk.kln.mit.encoders;

import lk.kln.mit.ConvertProgressListener;
import lk.kln.mit.Converter;
import ws.schild.jave.*;

import java.io.File;

public class MKVEncoder extends Converter{

    private int x = (int) (Math.random()*100);
    private String path="MediaContent/Source/MP4toMKV/videoplayback.mp4";
    private String destinationPath="MediaContent/Target/MP4toMKVConverted/output10"+x+".mkv";

    public MKVEncoder(){}

    public MKVEncoder(String path, String destinationPath){
        this.path = path;
        this.destinationPath = destinationPath;
    }


    @Override
    public void run() {
        encode();
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
        video.setBitRate(320000);
        video.setFrameRate(15);
        video.setSize(new VideoSize(400, 300));

        /* Step 4. Set Encoding Attributes*/
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("matroska");
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
}
