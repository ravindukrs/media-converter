package lk.kln.mit;

import lk.kln.mit.encoders.FLVEncoder;
import lk.kln.mit.encoders.MKVEncoder;
import lk.kln.mit.encoders.MP3Encoder;

public class MediaConverterFactory {
    public Converter getConverter(String converterType){
        if(converterType == null){
            return null;
        }
        if(converterType.equalsIgnoreCase("MP3")){
            return new MP3Encoder();

        } else if(converterType.equalsIgnoreCase("MKV")){
            return new MKVEncoder();

        } else if(converterType.equalsIgnoreCase("FLV")){
            return new FLVEncoder();
        }

        return null;
    }
}
