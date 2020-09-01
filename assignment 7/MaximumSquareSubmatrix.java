public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
	int max = 0;
	int count = 0;
	int[] square_count  = new int[a.length];
	
	for (int r = 0; r < a.length; r++) {
	    count = 0;
	    for (int c = 0; c < a.length; c++) {
		if (a[r][c] == 1) square_count[c] += 1;
		else square_count[c] = 0;
	    }

	    for (int i = 0; i < square_count.length; i++) {
		if (square_count[i] > max) {
		    count += 1;
		} else {
		    count = 0;
		}
			 
		if (count == max + 1) {
		    max += 1;
		    count = 0;
		}
	    }
	}

	return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
	int dim = StdIn.readInt();
	int[][] a = new int[dim][dim];
	for (int r = 0; r < dim; r++) {
	    for (int c = 0; c < dim; c++) {
		a[r][c] = StdIn.readInt();
	    }
	}

	StdOut.println(size(a));

	// for (int r = 0; r < dim; r++) {
	//     for (int c = 0; c < dim; c++) {
	// 	StdOut.print(a[r][c] + " ");
	//     }
	//     StdOut.println();
	// }
    }
}
