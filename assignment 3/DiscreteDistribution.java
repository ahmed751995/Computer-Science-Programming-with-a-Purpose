public class DiscreteDistribution {
    public static void main(String args[]) {
	int m = Integer.parseInt(args[0]);
	int[] a = new int[args.length];
	int r;
	String result = "";
	
	for (int i =1; i < args.length; i++)
	    a[i] = Integer.parseInt(args[i]);

	for (int i = 1; i < a.length; i++)
	    a[i] = a[i-1] + a[i];
	
	for (int i = 0; i < m; i++) {
	    if(i%25 == 0 && i != 0) result += "\n";
	    r = (int) (Math.random() * a[a.length - 1]);

	    for (int j = 1; j < a.length; j++) {
		if (r < a[j]) {
		    result += j;
		    break;
		}
	    }
	    result += " ";
	}
	System.out.println(result);
	// for(int i = 0; i < a.length; i++)
	//     System.out.println(a[i]);
    }
}
