public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
	double r = length / 2;
	StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	StdDraw.filledSquare(x, y, r);
	
	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.line(x - r, y - r, x + r, y - r);
	StdDraw.line(x + r, y - r, x + r, y + r);
	StdDraw.line(x + r, y + r, x - r, y + r);
	StdDraw.line(x - r, y + r, x - r, y - r);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
	if (n == 1) {
	    drawSquare(x, y, length);
	    return;
	}
	
	double r = length / 2;
	draw(n - 1, x + r, y + r, r);
	draw(n - 1, x - r, y + r, r);
	drawSquare(x, y, length);
	draw(n - 1, x - r, y - r, r);
	draw(n - 1, x + r, y - r, r);

    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	
	draw(n, 0.5, 0.5, 0.5);	
    }
}
