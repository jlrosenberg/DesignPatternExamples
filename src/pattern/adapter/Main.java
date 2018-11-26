package pattern.adapter;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        // First lets look at an example using the composition adapter (e.g. object adapter)

        LegacyRectangle legacyRectangle = new LegacyRectangleImpl(10, 20);
        ModernRectangle modernRectangle = new ModernRectangleImpl(new Point(24, 42));

        System.out.println("Modern rectangle: ");
        System.out.println(modernRectangle.getPosition().toString());

        // Wrap our legacy rectangle in the ObjectAdapter so it behaves like a modern rectangle
        ModernRectangle objectAdaptedRect = new ObjectAdapter(legacyRectangle);

        System.out.println("Object adapted rectangle acting like a modern one:");
        System.out.println(objectAdaptedRect.getPosition().toString());

        // Remove the comments and observe that the object adapted rectangle does not support old rectangle behavior.
        // objectAdaptedRect.getXCoordinate());
        // objectAdaptedRect.getYCoordinate());

        // Next lets look at an example that uses the inheritance adapter (e.g. class adapter)

        // Wrap our legacy rectangle in the ClassAdapter so it behaves like a modern rectangle
        ClassAdapter classAdaptedRect = new ClassAdapter(legacyRectangle);

        System.out.println("Class adapted rectangle acting like a modern one:");
        System.out.println(classAdaptedRect.getPosition().toString());

        System.out.println("Class adapted rectangle can still act like an old rectangle as well:");
        System.out.println("X Coordinate (using getXCoordinate method): "+classAdaptedRect.getXCoordinate());
        System.out.println("Y Coordinate (using getYCoordinate method): "+classAdaptedRect.getYCoordinate());
    }
}
