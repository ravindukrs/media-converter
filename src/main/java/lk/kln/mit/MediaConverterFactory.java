package lk.kln.mit;

import lk.kln.mit.encoders.FLVEncoder;
import lk.kln.mit.encoders.MKVEncoder;
import lk.kln.mit.encoders.MP3Encoder;

public class MediaConverterFactory {
    public Converter getConverter(String converterType, String fileName){
        if(converterType == null){
            return null;
        }
        if(converterType.equalsIgnoreCase("MP3")){
            return new MP3Encoder(fileName);

        } else if(converterType.equalsIgnoreCase("MKV")){
            return new MKVEncoder(fileName);

        } else if(converterType.equalsIgnoreCase("FLV")){
            return new FLVEncoder(fileName);
        }

        return null;
    }
}
