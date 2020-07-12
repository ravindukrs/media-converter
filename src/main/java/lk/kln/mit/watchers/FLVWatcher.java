package lk.kln.mit.watchers;

import java.io.IOException;
import java.nio.file.*;

public class FLVWatcher extends Thread {

    private static FLVWatcher instance = new FLVWatcher();

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path directory = Paths.get("MediaContent/Source/MP4toFLV/");

            WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            while(true){
                for(WatchEvent<?> event : watchKey.pollEvents()){
                    System.out.println(event.kind());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FLVWatcher getInstance(){
        return instance;
    }
}
