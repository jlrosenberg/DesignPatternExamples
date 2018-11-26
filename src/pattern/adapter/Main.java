package pattern.adapter;

import java.awt.*;

public class Main {


    public static void main(String[] args){

        //First lets look at an example using the composition adapter

        LegacyRectangle oldRect = new LegacyRectangleImpl(10, 20);
        ModernRectangle newRect = new ModernRectangleImpl(new Point(24, 42));

        //Wrap our old rectangle in the RectangleAdapter so it behaves like a modern rectangle
        ModernRectangle adaptedOldRect = new RectangleAdapter(oldRect);

        System.out.println("Old rectangle acting like a modern one:");
        System.out.println(adaptedOldRect.getPosition().toString());

        System.out.println("Modern rectangle: ");
        System.out.println(newRect.getPosition().toString());


        // Next lets look at an example that uses the inheritance adapter
        System.out.println("Now, using adapter that has inheritance");
        RectangleAdapterExtended adaptedOldRect2 = new RectangleAdapterExtended(oldRect);

        System.out.println("Old rectangle acting like a modern one");
        System.out.println(adaptedOldRect2.getPosition().toString());

        System.out.println("Old rectangle that has been adapted can still act like an old rectangle as well...");
        System.out.println("X Coordinate: "+adaptedOldRect2.getXCoordinate());
        System.out.println("Y Coordinate: "+adaptedOldRect2.getYCoordinate());



    }
}
