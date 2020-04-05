public class RightTriangle {
    public static void main(String args[]) {
	long x = Integer.parseInt(args[0]);
	long y = Integer.parseInt(args[1]);
	long z = Integer.parseInt(args[2]);
	
	boolean sign = x > 0 && y > 0 && z > 0;
	boolean first = (x * x) + (y * y) == (z * z);
	boolean second = (x * x) + (z * z) == (y * y);
	boolean third = (y * y) + (z * z) == (x * x);
	System.out.println((first || second || third) && sign);
    }
}
