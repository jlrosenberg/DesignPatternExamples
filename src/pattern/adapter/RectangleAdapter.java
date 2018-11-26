package pattern.adapter;

import java.awt.*;

/**
 * This is an example of an adapter that uses composition
 */
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
