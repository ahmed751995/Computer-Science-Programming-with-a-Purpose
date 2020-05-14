public class WorldMap {
    public static void main(String args[]) {
	int xScale = StdIn.readInt();
	int yScale = StdIn.readInt();
	StdDraw.setCanvasSize(xScale, yScale);
	StdDraw.setXscale(0, xScale);
	StdDraw.setYscale(0, yScale);

	while(!StdIn.isEmpty()) {
	    String name = StdIn.readString();
	    int size = StdIn.readInt();
	    double[] x = new double[size];
	    double[] y = new double[size];

	    for (int i = 0; i < size; i++) {
		x[i] = StdIn.readDouble();
		y[i] = StdIn.readDouble();
	    }
	    StdDraw.polygon(x, y);
	}
    }
}
