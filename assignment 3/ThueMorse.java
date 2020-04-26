public class ThueMorse {
    public static void main(String args[]) {
	int n = Integer.parseInt(args[0]);
	int[] a = new int[n];
	String result = "";
	boolean exceeded = false;
	for (int i = 1; i < n; i *= 2) {
	    for (int j = 0; j < i; j++) {
		if (i+j == a.length) {
		    exceeded = true;
		    break; 
		}
		if (a[j] == 1) a[i+j] = 0;
		else a[i+j] = 1;
	    }
	    if (exceeded) break;
	}
	// for (int i = 0; i < n; i++) {
	//     System.out.print(a[i] + " ");
	// }
	// System.out.println();

	for (int r = 0; r < n; r++) {
	    for (int c = 0; c < n; c++) {
		if (a[r] == a[c]) result += "+  ";
		else result += "-  ";
	    }
	    result += "\n";
	}
	System.out.println(result);
    }
}
