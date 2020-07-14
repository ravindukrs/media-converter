package lk.kln.mit.encoders;

import lk.kln.mit.ConvertProgressListener;
import lk.kln.mit.Converter;
import ws.schild.jave.*;

import java.io.File;

public class FLVEncoder extends Converter {

    private String path= config.getPath("source.flv");
    private String destinationPath= config.getPath("destination.flv");
    private String fileName = null;

    public FLVEncoder(){}

    public FLVEncoder(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void encode() {

        File videoFile= new File(path+fileName);
        File target = new File(destinationPath+fileName.replace(".mp4","")+".flv");

        ConvertProgressListener listener = new ConvertProgressListener(videoFile);

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac");
        audio.setBitRate(64000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);

        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264");
        video.setX264Profile(VideoAttributes.X264_PROFILE.BASELINE);
        video.setBitRate(320000);
        video.setFrameRate(15);
        video.setSize(new VideoSize(400, 300));

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("flv");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        try {
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(videoFile), target, attrs, listener);
            videoFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        encode();
    }
}
