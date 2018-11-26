# The Strategy Pattern

The technical definition of the strategy pattern is as follows, 

_Defines a set of encapsulated algorithms that can be swapped to carry out a specific behaviour_

The strategy pattern is best used when you want to choose an algorithm to use at runtime. Some common applications of the strategy pattern are as follows,
1. File Compression
2. Sorting Algorithms
3. Saving a file in different formats

Using the strategy pattern lets us define a set of algorithms, encapsulate each one inside of an object, and make them easily interchangeable.

Let's jump right into an example. Say that we are building an image editor, and we are working on our save file routine. We want our program to support saving in multiple formats, namely .jpg and .gif. 

First, let's define an interface for a file saving strategy,
```java
public interface FileSaveStrategy{
    void saveImage(BufferedImage img, String filename);
}
```
This interface has one method, saveImage, that takes in a BufferedImage object to save, and the name of the file to save it as.

Next, we need to implement this interface for each of the filetypes we want the user to be able to save the image as,

```java
public class JpgSaveStrategy implements FileSaveStrategy{
    public void saveImage(BufferedImage img, String filename){
        System.out.println("Saving img as "+filename+".jpg");
    }
}

public class GifSaveStrategy implements FileSaveStrategy{
    public void saveImage(BufferedImage img, String filename){
        System.out.println("Saving img as "+filename+".gif");
    }
}
```
I've given each of these strategies trivial implementations as we're not really concerned with the process of image file encoding in this class, so for now assume that the println calls are using some fancy java magic to also save the file correctly in the correct format.

Now, let's define a FileSaver, which is the class the user is going to interact with to try and save the file. Through the filesaver, you should be able to select the file type, pass in a name of the file to save/create, and then the filesaver should save the file appropriately.

```java
public class FileSaver{
    
    // Set a default save strategy of jpg (when you try and save a file on 
    // your computer, it usually has a default filetype that you can 
    // change if you want, right?
    private FileSaveStrategy saveMethod = new JpgSaveStrategy();
    
    // Details about how this image is generated modified are not 
    // important right now
    private BufferedImage myImage;
    
    
    public void setSaveStrategy(FileSaveStrategy saveMethod){
        this.saveMethod = saveMethod;
    }
    
    public void saveFile(String filename){
        saveMethod.saveImage(myImage, filename);
    }
}
```

Finally, let's put together a little sample client to show our strategy pattern in use!

```java
public class Client{
    public static void main(String[] args){
        FileSaver filesaver=new FileSaver();
        
        filesaver.setSaveStrategy(new JpgSaveStrategy());
        filesaver.saveFile("samplefile");
        
        
        filesaver.setSaveStrategy(new GifSaveStrategy());
        filesaver.saveFile("samplefile2");
    }
}
```
The strategy pattern can also be used to make decisions based on the outcome of several strategies - you went over this in class with the Tic Tac Toe example. If one strategy fails, you can fall back to a second strategy. Another application of the strategy pattern is to try multiple strategies, and pick the most frequent outcome.

### Additional Resources
1. https://dzone.com/articles/design-patterns-strategy
2. https://sourcemaking.com/design_patterns/strategy
3. https://www.geeksforgeeks.org/strategy-pattern-set-1/
4. https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm