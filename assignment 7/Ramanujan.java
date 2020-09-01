public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

	int upper_value =  (int)Math.round(Math.cbrt(n));
	int c = 0;
	int value1 = 0;

	for (int a = 1; a < upper_value; a++) {
	    double b = Math.cbrt(n - Math.pow(a, 3));
	    
	    if (b == (int)b && a != value1) {
		value1 = (int)b;
		c += 1;
	    }
	}
	if (c > 1) return true;
	else return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
	long n = Long.parseLong(args[0]);
	StdOut.println(isRamanujan(n));
    }
}
