package pattern.adapter;

import java.awt.*;

/**
 * This is an example of an adapter that uses composition (object adapter)
 */
public class ObjectAdapter implements ModernRectangle {

    private LegacyRectangle r;

    public ObjectAdapter(LegacyRectangle r){
        this.r = r;
    }

    @Override
    public Point getPosition() {
        return new Point(r.getXCoordinate(), r.getYCoordinate());
    }
}
