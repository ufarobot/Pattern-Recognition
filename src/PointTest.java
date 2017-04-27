/**
 * Created by spec on 25.04.2017.
 */
public class PointTest {
    /*
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     */
    @org.junit.Test
    public void compareTo() throws Exception {
        Point a = new Point(2, 2);
        Point b = new Point(1, 1);
        assert a.compareTo(b) > 0;
        assert b.compareTo(a) < 0;

        b = new Point(3, 1);
        assert a.compareTo(b) > 0;
        assert b.compareTo(a) < 0;

        b = new Point(2, 2);
        assert a.compareTo(b) == 0;

        b = new Point(3, 2);
        assert a.compareTo(b) < 0;
        assert b.compareTo(a) > 0;

        a = b;
        assert b.compareTo(a) == 0;

        a = new Point(-1, -2);
        b = new Point(-1, -3);
        assert a.compareTo(b) > 0;
        assert b.compareTo(a) < 0;
    }

    @org.junit.Test
    public void slopeTo() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(-1, 1);
        assert a.slopeTo(b) == -1;
        assert b.slopeTo(a) == -1;

        b = new Point(1 , 2);
        assert a.slopeTo(b) == 2;

        b = new Point(2, 1);
        assert a.slopeTo(b) == 0.5;

        // horizontal line
        b = new Point(1, 0);
        assert a.slopeTo(b) == +0.0;
        b = new Point(-1, 0);
        assert a.slopeTo(b) == +0.0;

        // vertical line
        b = new Point(0, 1);
        assert a.slopeTo(b) == Double.POSITIVE_INFINITY;
        b = new Point(0, -1);
        assert a.slopeTo(b) == Double.POSITIVE_INFINITY;

        // points equal
        b = new Point(0, 0);
        assert a.slopeTo(b) == Double.NEGATIVE_INFINITY;
        b = a;
        assert a.slopeTo(b) == Double.NEGATIVE_INFINITY;
    }

    @org.junit.Test
    public void slopeOrder() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(1, 2);
        assert a.slopeOrder().compare(b, c) < 0;
        assert a.slopeOrder().compare(c, b) > 0;

        c = new Point(1, 1);
        assert a.slopeOrder().compare(b, c) == 0;

        c = new Point(0,1);
        assert a.slopeOrder().compare(b, c) < 0;

        c = new Point(1, 0);
        assert a.slopeOrder().compare(b, c) > 0;

        c = new Point(0,0);
        assert a.slopeOrder().compare(b, c) > 0;
    }

}