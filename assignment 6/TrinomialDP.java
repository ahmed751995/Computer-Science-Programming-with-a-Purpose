public class TrinomialDP {

    // private static long [][] t;
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
	if (n == 0 && k == 0) return 1;
	if (k < -n || k > n) return 0;
	int newk = Math.abs(k);
	long[][] t = new long[n + 1][(newk + n) * 5];
	int mn = n;
	int mk = k;
	// int xk = (int)(n/2 + 1);
	while (!(mk < -mn)) {
	    mn -= 1;
	    mk -=1;
	}
	// System.out.println("tn = " + mn + " tk = " + mk + " xk = " + xk);
	t[0][0] = 1;

	// for (int i = 1; i <= n + 1; i++) {
	//     t[0][i] = 0;
	// }

	for (int i = 1; i <= n; i++) {

	    for (int j = mk; j <= n + 1; j++) {
		
		if (j < -i || j > i) {
		    if (j < 0) t[i][-j + n + 1] = 0;
		    else t[i][j] = 0;
		}
		
		else {
		    if (j > 0) {
			t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1];
		    }
		    else if (j == 0) {
			t[i][j] = t[i - 1][n + 2] + t[i - 1][j] + t[i - 1][j + 1];
		    }
		    else if (j == -1) {
			t[i][-j + n + 1] = t[i - 1][0] +
			    t[i - 1][-j + n + 1] +
			    t[i - 1][-j + n + 2];
		    }
		    else {
			t[i][-j + n + 1] = t[i - 1][-j + n] +
			    t[i - 1][-j + n + 1] +
			    t[i - 1][-j + n + 2];
		    }
		}
		// if(j < 0) 
		//     System.out.println("i = "+ i + " j = " + j + " t[i][j] = " + t[i][-j + n + 1]);
		// else
		//     System.out.println("i = "+ i + " j = " + j + " t[i][j] = " + t[i][j]);
	    }
	}
	// for (int o = 0; o < t.length; o++) {
	//     for(int j = 0; j < t[0].length; j++)
	// 	System.out.print(t[o][j] + " ");
	//     System.out.println("");
	// }
	if (k < 0) return t[n][-k + n + 1];
	return t[n][k];
    }
    // public static long Rtrinomial(int n, int k) {
    // 	if (n == 0 && k == 0)
    // 	    return 1;
    // 	if (k < -n || k > n)
    // 	    return 0;

    // 	if (k < 0) {
    // 	    if (t[n][-k + n] > 0)
    // 		return t[n][-k + n];
    // 	    else {
    // 		t[n][-k + n] = trinomial(n - 1, k - 1) +
    // 		trinomial(n - 1, k) +
    // 		trinomial(n - 1, k + 1);
    // 	    return t[n][-k + n];
    // 	    }
    // 	}
	
    // 	if (t[n][k] > 0)
    // 	    return t[n][k];
	
    // 	else {
    // 	    t[n][k] = trinomial(n - 1, k - 1) +
    // 		trinomial(n - 1, k) +
    // 		trinomial(n - 1, k + 1);
    // 	    return t[n][k];
    // 	}
    // }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int k = Integer.parseInt(args[1]);
	//	t = new long[n + 1][(k + n) * 2];
	System.out.println(trinomial(n, k));
    }
}
