package corridor.model;

/**
 * Created by gena on 25/04/17.
 */
public class StackImagingEntry {
    public final double xCoord;
    public final double yCoord;
    public final double horiz;
    public final double vert;

    public StackImagingEntry(double xCoord, double yCoord, double horiz, double vert) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.horiz = horiz;
        this.vert = vert;
    }
    @Override
    public String toString() {
        return "[" + xCoord + ", " + yCoord + ", " + horiz + ", " + vert + "]";
    }
}
