package pattern.strategy.filestrategyexample;

import java.awt.image.BufferedImage;

public interface FileSaveStrategy{
    void saveImage(BufferedImage img, String filename);
}
