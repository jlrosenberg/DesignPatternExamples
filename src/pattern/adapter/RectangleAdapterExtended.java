package pattern.adapter;

import java.awt.*;

/**
 * This is an example of an adapter that uses inheritance
 */
public class RectangleAdapterExtended extends LegacyRectangleImpl implements ModernRectangle {

    public RectangleAdapterExtended(LegacyRectangle r){
        super(r.getXCoordinate(), r.getYCoordinate());
    }

    @Override
    public Point getPosition() {
        return new Point(this.getXCoordinate(), this.getYCoordinate());
    }
}
