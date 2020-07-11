package lk.kln.mit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderWatcher {

    private String folderPath;
    private List<File> fileList = new ArrayList<>();

    public FolderWatcher(String folderPath){
        this.folderPath = folderPath;
    }

    public void fileAdded(File file){
        fileList.add(file);
    }

    public void fileDeleted(File file){
        fileList.remove(file);
    }

    public void encode(){
        for (File media : fileList){
            MediaConverter converter = new MediaConverter();
        }
    }
}
