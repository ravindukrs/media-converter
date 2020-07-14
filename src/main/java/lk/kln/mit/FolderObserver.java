package lk.kln.mit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderObserver {

    MediaConverterFactory converterFactory = new MediaConverterFactory();


    private String folderPath;
    private List<String> fileList = new ArrayList<>();

    public FolderObserver(String folderPath){
        this.folderPath = folderPath;
    }

    public void fileAdded(String file){
        fileList.add(file);
    }

    public void fileDeleted(String file){
        fileList.remove(file);
    }

    public void encode(){
        for (String file : fileList){
            //MediaConverter converter = new MediaConverter();
//            Converter mp3Converter = converterFactory.getConverter("MP3", file);
//            mp3Converter.start();
        }
    }
}
