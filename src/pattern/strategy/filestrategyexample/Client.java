package pattern.strategy.filestrategyexample;

public class Client{
    public static void main(String[] args){
        FileSaver filesaver=new FileSaver();

        filesaver.setSaveStrategy(new JpgSaveStrategy());
        filesaver.saveFile("samplefile");

        filesaver.setSaveStrategy(new GifSaveStrategy());
        filesaver.saveFile("samplefile2");
    }
}