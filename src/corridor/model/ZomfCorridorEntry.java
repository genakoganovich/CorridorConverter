package corridor.model;

public class ZomfCorridorEntry {
    public final double xCoord;
    public final double yCoord;
    public final double v;
    public final double a;
    public final double t;
    public final double deltaV;
    public final double deltaA;

    public ZomfCorridorEntry(double xCoord, double yCoord, double v,
                             double a, double t, double deltaV, double deltaA) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.v = v;
        this.a = a;
        this.t = t;
        this.deltaV = deltaV;
        this.deltaA = deltaA;
    }
    @Override
    public String toString() {
        return "" + xCoord + "\t" + yCoord + "\t" + v + "\t" + a
                + "\t" + t + "\t" + deltaV + "\t" + deltaA;
    }
}
