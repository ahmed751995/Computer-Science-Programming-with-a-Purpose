public class ColorHSB {

    // Creates a color with hue h, saturation s, and brightness b.
    private int h, s, b;
    public ColorHSB(int hue, int saturation, int brightness) {
	if (hue < 0 || hue > 359)
	    throw new IllegalArgumentException();
	
	if (saturation < 0 || saturation > 100 )
	    throw new IllegalArgumentException();
	
	if (brightness < 0 || brightness > 100)
	    throw new IllegalArgumentException();
	
	h = hue;
	s = saturation;
	b = brightness;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
	
	return  "(" + h + "," + s + "," + b +")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
	if (s == 0 || b == 0)
	    return true;
	return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
	if (that == null)
	    throw new IllegalArgumentException();

	int minHue = Math.min((int) Math.pow(h - that.h, 2),
			      (int) Math.pow(360 - Math.abs(h - that.h), 2));
	
	return minHue + (int) Math.pow(s - that.s, 2) + (int) Math.pow(b - that.b, 2);
    }

    // Sample client (see below).
    public static void main(String[] args) {
	int hue = Integer.parseInt(args[0]);
	int saturation = Integer.parseInt(args[1]);
	int brightness = Integer.parseInt(args[2]);
	ColorHSB color = new ColorHSB(hue, saturation, brightness);
	int min = -1;
	String closestColor = "";
	
	while(!StdIn.isEmpty()) {
	    String name = StdIn.readString();
	    int h = StdIn.readInt();
	    int s = StdIn.readInt();
	    int b = StdIn.readInt();
	    ColorHSB c = new ColorHSB(h, s, b);
	    
	    if (min == -1) {
		min = color.distanceSquaredTo(c);
		closestColor = name + " " + c;
	    }
	    
	    if(color.distanceSquaredTo(c) < min){
		closestColor = name + " " + c;
		min = color.distanceSquaredTo(c);
	    }
	}
	
	StdOut.println(closestColor);
    }

}
