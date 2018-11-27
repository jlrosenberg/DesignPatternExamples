# The Factory Pattern

Many students have had questions about the factory pattern, so here is a bit of elaboration on "_the factory pattern_".
The _factory pattern_ in itself is a misnomer, as there is no one true factory pattern. There are in fact several types of factory patterns, all grouped underneath the umbrella title of factory pattern. The most commonly found factory patterns are the following
1. Simple Factory Pattern
2. Factory Method Pattern
3. Abstract Factory Pattern

These are all fairly similar, and often can be substituted for one another, but have slightly different implementations that set them apart from each other. 

### The Simple Factory Pattern
If you had to describe the simple factory pattern in one sentence, I would describe it as the following:

**In simple factory pattern, we have a factory class which has a method that returns different types of object based on given input.**

You've likely used something like this somewhere in your Easy Animator project at this point - perhaps when trying to decide the correct way to construct a shape object in the declareShape() method of the Builder.

Here's an example from my implementation of the animator, as an example.

```java
public class MyShapeFactory{
    private static Shape shapeFactory(String type){
             if(type.equals("rectangle")){
                 return new Rectangle();
             }
             if(type.equals("ellipse")){
                 return new Ellipse();
             }
 
             throw new IllegalArgumentException("No shape with type \""+type+"\" exists");
    }
}
```
You can find a full code example of the simple factory pattern in the simplefactorypattern package.


### The Factory Method Pattern
The factory method pattern differs a bit in that we don't just have one factory that creates all of our objects for us. We create an interface that has a factory method. Continuing with our example of Shapes...
```java
public interface ShapeFactory{
    Shape getShape();
}
```

Next, we'll implement this factory for each type of Shape.

```java
public class RectangleFactory implements ShapeFactory{
     Shape getShape(){
         return new Rectangle();
     }
 }
 
 public class CircleFactory implements ShapeFactory{
     Shape getShape(){
         return new Circle();
     }
 }
```

By doing this, we are now shifting the responsibility of determining the type of shape that needs to be constructed out of the getShape() method, and instead placing it on the type of factory that we are using. Check out the additional resources section for some more examples of this, including a more in-depth explanation and some UML diagrams.

### The Abstract Factory Pattern
The abstract factory pattern allows us to create a family of related objects, without explicitly specifying their classes. This allows us to implement several different versions of this factory, for different scenarios. Once again, continuing with our shape example:

```java
public interface ShapeFactory{
    Shape createRectangle();
    
    Shape createCircle();
}
```

Now, let's look at two implementations of this interface,

```java
public class ShapeFactory2D implements ShapeFactory{
    Shape createRectangle(){
        return new Rectangle2D();
    }
    
    Shape createCircle(){
        return new Circle2D();
    }
}

public class ShapeFactory3D implements ShapeFactory{
    Shape createRectangle(){
        return new Rectangle3D();
    }
    
    Shape createCircle(){
        return new Circle3D();
    }
}
```

The Abstract Factory pattern design allows us to have different versions of a Rectangle and Circle depending on which factory is used. 


## _Additional Resources_

Here is a great explanation of the differences between the 3 most common types of factory patterns, complete with UML diagram examples: https://vivekcek.wordpress.com/2013/03/17/simple-factory-vs-factory-method-vs-abstract-factory-by-example/

1. https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
2. https://www.journaldev.com/1392/factory-design-pattern-in-java

