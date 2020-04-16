public class BandMatrix {
    public static void main(String args[]) {
	int n = Integer.parseInt(args[0]);
	int width = Integer.parseInt(args[1]);
	String s = "";
	for(int r = 0; r < n; r++) {
	    for(int c = 0; c < n; c ++) {
		if(Math.abs(r-c) <= width) {
		    s += "* ";
		} else {
		    s += "0 ";
		}
	    }
	    System.out.println(s);
	    s = "";
	}
    }
}
