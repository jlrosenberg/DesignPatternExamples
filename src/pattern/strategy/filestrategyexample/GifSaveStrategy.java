package pattern.strategy.filestrategyexample;

import java.awt.image.BufferedImage;

public class GifSaveStrategy implements FileSaveStrategy{
    public void saveImage(BufferedImage img, String filename){
        System.out.println("Saving img as "+filename+".gif");
    }
}