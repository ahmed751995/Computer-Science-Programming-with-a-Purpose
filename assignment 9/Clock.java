public class Clock {

    private int h, m;
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int hour, int min) {
	if (hour < 0 || hour > 23)
	    throw new IllegalArgumentException();
	if (min < 0 || min > 59)
	    throw new IllegalArgumentException();
	h = hour;
	m = min;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
	int i = s.indexOf(":");
	
	if (i < 0)
	    throw new IllegalArgumentException();
	
	if (s.substring(0, i).length() != 2 ||
	    s.substring(i + 1).length() != 2)
	    throw new IllegalArgumentException();
	
	int tempH = Integer.parseInt(s.substring(0, i));
	int tempM = Integer.parseInt(s.substring(i + 1));
	
	if (tempH < 0 || tempH > 23)
	    throw new IllegalArgumentException();
	
	if (tempM < 0 || tempM > 59)
	    throw new IllegalArgumentException();
	
	h = tempH;
	m = tempM;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
	String H = String.format("%02d", h);
	String M = String.format("%02d", m);
	
	return H + ":" + M;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
	if (h < that.h)
	    return true;
	if (h == that.h)
	    if (m < that.m)
		return true;
	return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
	h = ((m + 1) / 60 + h) % 24;
	m = (m + 1) % 60;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
	// dividing delta to hours and minutes
	if (delta < 0)
	    throw new IllegalArgumentException();
	int hours = delta / 60; 
	int mins = delta % 60;
	
	h = (((h + hours) % 24) + ((m + mins)/ 60)) % 24;
	m = (m + mins) % 60;
    }

    // Test client (see below).
    public static void main(String[] args) {
	Clock cHM = new Clock(22, 59);
	Clock cS = new Clock("22:19");
	StdOut.println("cHM is " + cHM);
	StdOut.println("cS is " + cS);
	cHM.tic();
	StdOut.println("tic one min equal = " + cHM);
	cHM.toc(70);
	StdOut.println("toc 40 min equal = " + cHM);
	StdOut.println("is EarlierThan = " + cS.isEarlierThan(cHM));
    }
}
