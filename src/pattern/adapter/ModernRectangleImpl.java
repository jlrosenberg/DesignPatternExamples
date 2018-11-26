package pattern.adapter;

import java.awt.*;

public class ModernRectangleImpl implements ModernRectangle {

    private Point p;

    public ModernRectangleImpl(Point p) {
        this.p = p;
    }

    @Override
    public Point getPosition() {
        return p;
    }
}
