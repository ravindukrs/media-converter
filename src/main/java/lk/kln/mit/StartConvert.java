package lk.kln.mit;

public class StartConvert {
public static void startConvert(){
 MP3Watcher mp3Watcher = MP3Watcher.getInstance();
        mp3Watcher.start();
        FLVWatcher flvWatcher = FLVWatcher.getInstance();
        flvWatcher.start();
        MKVWatcher mkvWatcher = MKVWatcher.getInstance();
        mkvWatcher.start();

}
}
