public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
	long count = 0;
	for (int i = 0; i < a.length; i++) {
	    for (int j = i + 1; j < a.length; j++) {
		if (a[j] < a[i]) count += 1;
	    }
	}
	return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
	int[] permutation = new int[n];
	int value = n - 1;
	int max_perm = 0;
	
	while (k != 0) {
	    if ( k < value) {
		permutation[n - 1 - (int)k] = value;
		k = 0;
	    }
	    else {
		permutation[max_perm] = value;
		max_perm += 1;
		k  -= value;
		value -= 1;
		
	    }
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
	    if (permutation[i] == 0 ) {
		permutation[i] = count;
		count++;
	    }
	}
	return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	long k = Long.parseLong(args[1]);
	int[] permutation = generate(n , k);

	// prints the permutation array
	for (int i = 0; i < n; i++) {
	    StdOut.print(permutation[i]);
	    if (i < n -1) StdOut.print(" ");
	}
	StdOut.println();
    }
}
