public class GreatCircle {
    public static void main(String args[]) {
	double x1 = Math.toRadians(Double.parseDouble(args[0]));
	double y1 = Math.toRadians(Double.parseDouble(args[1]));
	double x2 = Math.toRadians(Double.parseDouble(args[2]));
	double y2 = Math.toRadians(Double.parseDouble(args[3]));
	double r = 6371.0;
	
	double first = Math.sin((x2-x1)/2);
	first  = first * first;

	double second = Math.sin((y2-y1)/2);
	second = (second * second) * Math.cos(x1) * Math.cos(x2);

	double result = 2 * r * Math.asin(Math.sqrt(first + second));
	System.out.println(result + " kilometers");
    }
}
