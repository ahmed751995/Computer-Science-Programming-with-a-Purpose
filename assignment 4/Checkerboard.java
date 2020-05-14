public class Checkerboard {
    public static void main(String args[]) {
	int n = Integer.parseInt(args[0]);
	double rad = 0.5;
	double x = 0.5;
	double y = 0.5;
	boolean isFill = true;
	boolean vertical = true;
	StdDraw.setScale(0, n);
	// StdDraw.filledSquare(x , y, rad);
	for (int c = 0; c < n; c++) {
	    for (int r = 0; r < n; r++) {
		if (isFill) StdDraw.setPenColor(StdDraw.BLUE);
		else StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		
		StdDraw.filledSquare(x + r, y + c, rad);
		isFill = !isFill;		    
	    }
	    vertical = !vertical;
	    isFill = vertical;
	}
    }
}
