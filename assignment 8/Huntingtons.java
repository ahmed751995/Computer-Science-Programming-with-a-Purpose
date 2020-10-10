public class Huntingtons {

    // // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
	int repeats = 0;
	int max = 0, i = 0;

	while(i < dna.length() - 2) {
	    String sub = dna.substring(i, i + 3);
	    if (sub.equals("CAG")) {
		repeats += 1;
		i += 2;
	    }
	    else repeats = 0;
	    if (repeats > max) {
		max = repeats;
		// StdOut.println("max = " + max);
	    }
	    i += 1;
	}
	return max;
    }

    // // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
	s = s.replace("\n", "");
	s = s.replace("\t", "");
	s = s.replace(" ", "");
	return s;
    }

    // // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
	if (maxRepeats >= 0 && maxRepeats < 10) return "not human";
	else if (maxRepeats < 36) return "normal";
	else if (maxRepeats < 40) return "high risk";
	else if (maxRepeats < 181) return "Huntington’s";
	else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
	In in = new In(args[0]);
	String s = in.readAll();
	String DNA = removeWhitespace(s);
	int max_repeats = maxRepeats(DNA);
	String result = diagnose(max_repeats);
	StdOut.println("max repeats = " + max_repeats);
	StdOut.println(result);
    }

}
