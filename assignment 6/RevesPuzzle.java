public class RevesPuzzle {

    // print steps to solve hanoi problem with three poles
    private static void hanoi(int n, int k, char source, char temp, char dist) {
	if (n == 0) return;
	
	hanoi(n - 1, k, source, dist, temp);
	
	System.out.println("Move disc "+ (n + k) + " from " + source + " to " + dist);
	
	hanoi(n - 1, k, temp, source, dist);
    }

    // print steps to solve hanoi problem with four poles
    private static void hanoiFour(int n, char s, char c1, char c2, char d) {
	if (n <= 0) return;
	
	// if (n == 1) {
	//     System.out.println("Move disc "+ n + " from " + s + " to " + d);
	//     return;
	// }

	int k =(int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

	hanoiFour(k, s, d, c1, c2);
	hanoi(n-k, k, s, c1, d);
	hanoiFour(k, c2, s, c1, d);

	// hanoiFour(n - 2, s, d, c1, c2);
	
	// System.out.println("Move disc "+ (n - 1) + " from " + s + " to " + c1);
	// System.out.println("Move disc "+ (n) + " from " + s + " to " + d);
	// System.out.println("Move disc "+ (n - 1) + " from " + c1 + " to " + d);
	
	// hanoiFour(n - 2, c2, s, c1, d);
    }
    
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int k =(int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

	hanoiFour(n, 'A', 'B', 'C', 'D');
	// hanoiFour(k, 'A', 'D', 'C', 'B');
	// hanoi(n - k, k,'A', 'C', 'D');
	// hanoiFour(k, 'B', 'A', 'C', 'D');
    }
}
