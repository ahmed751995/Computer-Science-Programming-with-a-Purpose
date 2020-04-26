public class Birthday {
    public static void main(String args[]) {
	int n = Integer.parseInt(args[0]);
	int trials = Integer.parseInt(args[1]);
	int count = 0;
	double fraction = 0;
	boolean found = false;
	int newPerson, c, size;
	int[] people;
	size = 1;
	while (fraction < 0.50) {
	    people = new int[size];
	    for (int t = 1; t <= trials; t++) {
		c = 0;
		while (!found && c < size) {
		    newPerson = (int)(Math.random() * n);
		    for (int k = 0; k < c; k++) {
			if (people[k] == newPerson) {
			    found = true;
			    break;
			}
		    }
		    if (!found) people[c] = newPerson;
		    c++;
		}
		if (found) {
		    found = false;
		    count += 1;
		}
	    }
	    fraction = count / (double)trials;
	    System.out.println(size+ "  " + count + " " + fraction);
	    size += 1;
	    count = 0;
	}
    }
}
