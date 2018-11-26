package pattern.factory.simplefactorypattern;


public class StaticShapeFactory {

    /**
     * This method takes in a string shapeType and returns the corresponding shape object, if it is supported by this
     * factory.
     *
     * @param shapeType The type of shape object to construct
     * @return an implementation of {@link Shape} matching the passed shapeType.
     */
    public static Shape getShape(String shapeType) {

        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }

        if (shapeType.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }

        // If we do not recognize this type of shape, throw an exception
        throw new IllegalArgumentException("Shape of type " + shapeType + " is not supported by ConstructableShapeFactory");
    }
}
