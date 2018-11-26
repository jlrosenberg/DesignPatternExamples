# The Adapter Pattern

The adapter pattern is a powerful and important tool when trying to make different pieces of code work together, as you all have seen/will see soon with assignment 8. It's very easy to relate this pattern to real world examples - in order to plug my macbook pro into this projector, I need to use a usb-c to hdmi adapter. Without this adapter, the video outputted by my laptop is incompatible with the projecter. The adapter converts my video signal from one format to another so that the target (projector) can understand the source (laptop). 

That being said, let's look at a code example. Using the recurring theme of shapes, say I have an interface, LegacyRectangle. 

```java
public interface LegacyRectangle {
    
    /**
     * Gets the x coordinate of this rectangle.
     * 
     * @return the x coordinate of this rectangle
     */
    int getXCoordinate();

    /**
     * Gets the y coordinate of this rectangle.
     * 
     * @return the y coordinate of this rectangle
     */
    int getYCoordinate();
}
```

Assume I also have a working implementation of this interface, LegacyRectangleImpl, and it has a constructor that takes in two integer parameters, an x and a y. 

Now, this interface works fine, but then one day you recieve a memo from your boss, who is a member of the modern rectangle rights movement. He wants you to make the legacy rectangle work with the new and improved modern rectangle interface. This interface is specified below,
```java
public interface ModernRectangle {

    /**
     * Return the position of this rectangle in the cartesian plane.
     *
     * @return the position of this rectangle in cartesian coordinates.
     */
    Point getPosition();
}
```

It's your task to bridge the gap between these two interfaces, and we do this using an adapter.

### The Object Adapter
First, let's look at an adapter example that uses composition to achieve its goal. This is called an object adapter. It takes an object of one type, and gives it the behaviors of a new type.

```java
public class RectangleAdapter implements ModernRectangle {

    private LegacyRectangle r;

    public RectangleAdapter(LegacyRectangle r){
        this.r = r;
    }

    @Override
    public Point getPosition() {
        return new Point(r.getXCoordinate(), r.getYCoordinate());
    }
}
```

This adapter does the job! It takes in our old LegacyRectangle and makes it act like it is a modern rectangle. You'll notice that the RectangleAdapter uses a **has-a relationship** with LegacyRectangle, which signifies that this is a case of composition - indicating that this is an object adapter. This does the job, but it also means we can't use the RectangleAdapter as an instance of LegacyRectangle - it doesn't have those methods publicly visible.

### The Class Adapter

Now, let's try using inheritance instead of composition, and see what that looks like. This practice is known as using a class adapter, since it transforms an entire class to have new behaviors while maintaining the functionality of the original class.
```java
public class RectangleAdapterExtended extends LegacyRectangleImpl implements ModernRectangle {

    public RectangleAdapterExtended(LegacyRectangle r){
        super(r.getXCoordinate(), r.getYCoordinate());
    }

    @Override
    public Point getPosition() {
        return new Point(this.getXCoordinate(), this.getYCoordinate());
    }
}
```

This adapter doesn't contain an instance of LegacyRectangle - it is a LegacyRectangle! It provides the necessary features of a ModernRectangle, but it also lets us treat it as a LegacyRectangle. This can be useful, but can also be dangerous in specific cases (i.e. Perhaps there is an invariant maintained inside of the target that can be violated using the methods of source class/interface - in this case using inheritance would break this invariant, and composition would be a better solution).

You can look at the Main class in this package to see how these adapters are used. 

## Additional Resources
1. https://www.geeksforgeeks.org/adapter-pattern/
2. https://sourcemaking.com/design_patterns/adapter
3. https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm