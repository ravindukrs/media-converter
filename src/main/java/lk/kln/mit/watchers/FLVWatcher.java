package lk.kln.mit.watchers;

import lk.kln.mit.Converter;
import lk.kln.mit.Watcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FLVWatcher extends Watcher {

    private static FLVWatcher instance = new FLVWatcher();

    @Override
    public void run() {
        try {

            String[] fileNames;
            File f = new File("MediaContent/Source/MP4toFLV/");
            fileNames = f.list();

            for (String file : fileNames) {
                //System.out.println(file);
                if(file.contains(".mp4")){
                    encode(file);
                }
            }


            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path directory = Paths.get("MediaContent/Source/MP4toFLV/");

            WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            while(true){
                for(WatchEvent<?> event : watchKey.pollEvents()){


                    String eventKind = event.kind().toString();
                    String file = event.context().toString();


                    if(!file.equals(".DS_Store")&&eventKind.equals("ENTRY_CREATE")&&file.contains(".mp4")){
                        //System.out.println("Context: "+file+" eventKind: "+eventKind);
                        encode(file);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void encode(String file){
        Converter flvConverter = converterFactory.getConverter("FLV", file);
        flvConverter.start();
    }

    public static FLVWatcher getInstance(){
        return instance;
    }
}
