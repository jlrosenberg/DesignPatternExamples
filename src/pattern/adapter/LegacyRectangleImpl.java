package pattern.adapter;

public class LegacyRectangleImpl implements LegacyRectangle {


    private int x;
    private int y;

    public LegacyRectangleImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getXCoordinate() {
        return x;
    }

    @Override
    public int getYCoordinate() {
        return y;
    }
}
