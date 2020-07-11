package lk.kln.mit;

        import me.tongfei.progressbar.ProgressBar;
        import org.w3c.dom.ls.LSOutput;
        import ws.schild.jave.EncoderProgressListener;
        import ws.schild.jave.MultimediaInfo;

        import java.io.File;


public class ConvertProgressListener implements EncoderProgressListener {

    File currentlyEncodingFile;

    public ConvertProgressListener(File file){
        currentlyEncodingFile = file;
    }

    @Override
    public void sourceInfo(MultimediaInfo multimediaInfo) {

    }

    @Override
    public void progress(int i) {
        double progress = Math.round(i / 1000.00*100);

        System.out.print("Encoding " + currentlyEncodingFile.getName()+"... ");
        System.out.print(" "+progress+"%\r");

        if(progress == 100.0){
            System.out.print("Encoding Complete ("+currentlyEncodingFile.getName()+")\r");
        }

    }

    @Override
    public void message(String s) {

    }
}
