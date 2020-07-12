package lk.kln.mit.watchers;

import java.io.IOException;
import java.nio.file.*;

public class MKVWatcher extends Thread {

    private static MKVWatcher instance = new MKVWatcher();

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path directory = Paths.get("MediaContent/Source/MP4toMKV/");

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

    public static MKVWatcher getInstance(){
        return instance;
    }
}
