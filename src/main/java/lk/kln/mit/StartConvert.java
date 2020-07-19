package lk.kln.mit;

import lk.kln.mit.watchers.FLVWatcher;
import lk.kln.mit.watchers.MKVWatcher;
import lk.kln.mit.watchers.MP3Watcher;

public class StartConvert {
public static void startConvert(){
        //Start watchers on all 3 folders.
        MP3Watcher mp3Watcher = MP3Watcher.getInstance();
        mp3Watcher.start();

        FLVWatcher flvWatcher = FLVWatcher.getInstance();
        flvWatcher.start();

        MKVWatcher mkvWatcher = MKVWatcher.getInstance();
        mkvWatcher.start();

}
}
