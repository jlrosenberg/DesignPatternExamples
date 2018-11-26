package pattern.strategy.filestrategyexample;

import java.awt.image.BufferedImage;

public class FileSaver{

    // Set a default save strategy of jpg (when you try and save a file on your computer, it usually has a
    // default filetype that you can change if you want, right?
    private FileSaveStrategy saveMethod = new JpgSaveStrategy();

    //Details about how this image is generated modified are not important right now
    private BufferedImage myImage;


    public void setSaveStrategy(FileSaveStrategy saveMethod){
        this.saveMethod = saveMethod;
    }

    public void saveFile(String filename){
        saveMethod.saveImage(myImage, filename);
    }
}
