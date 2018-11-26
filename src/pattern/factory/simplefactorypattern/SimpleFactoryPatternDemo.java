package pattern.factory.simplefactorypattern;

/**
 * An example using both our constructableShapeFactory and our staticShapeFactory. Both of these options have the same
 * exact output, and neither one is necessarily better than the other - they're just different options, either is fine.
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {

        System.out.println("Using our constructable factory:");
       constructableExample();


        System.out.println("\n\nUsing our static factory");
       staticExample();

    }

    public static void constructableExample(){
        //Instantiate our factory object.
        ConstructableShapeFactory shapeFactory = new ConstructableShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("circle");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("rectangle");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Triangle and call its draw method.
        Shape shape3 = shapeFactory.getShape("triangle");

        //call draw method of triangle
        shape3.draw();
    }


    public static void staticExample(){

        //Since the getShape() method is static, we don't need to instantiate a factory object.
        Shape shape1 = StaticShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = StaticShapeFactory.getShape("rectangle");
        shape2.draw();

        Shape shape3 = StaticShapeFactory.getShape("triangle");
        shape3.draw();
    }
}
