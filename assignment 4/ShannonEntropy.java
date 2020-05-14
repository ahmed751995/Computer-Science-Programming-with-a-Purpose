public class ShannonEntropy {
    public static void main(String args[]) {
	int m = Integer.parseInt(args[0]);
	double[] array = new double[m + 1];
	int count = 0;
	double result = 0;
	
	while(!StdIn.isEmpty()) {
	    int value = StdIn.readInt();
	    array[value] += 1;
	    count++;
	}

	for (int i = 1; i < array.length; i++) {
	    if (array[i] != 0) {
		double pi = array[i] / count;
		result += - (pi * Math.log(pi)/ Math.log(2));
	    }
	}
	
	StdOut.printf("%.4f\n", result);
    }
}
