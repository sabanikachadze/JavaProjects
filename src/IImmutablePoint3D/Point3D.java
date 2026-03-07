package IImmutablePoint3D;

public class Point3D {
    public static final Point3D ORIGIN = new Point3D(0, 0, 0);
    final double x;
    final double y;
    final double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point3D other){

        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2) + Math.pow(other.z - z, 2));
    }

    public Point3D translate(double dx, double dy, double dz){
        return new Point3D(x + dx,y + dy,z + dz);
    }

    public Point3D scale(double factor){
        return new Point3D(x * factor,y * factor,z * factor);
    }

    public Point3D midpoint(Point3D other){
        return new Point3D((other.x + x) / 2,(other.y + y) / 2,(other.z + z) / 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point3D)) return false;

        Point3D other = (Point3D) obj;

        return Double.compare(x, other.x) == 0 &&
               Double.compare(y, other.y) == 0 &&
               Double.compare(z, other.z) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y, z);
    }


    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

