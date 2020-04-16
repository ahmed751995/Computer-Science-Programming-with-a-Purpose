public class RandomWalkers {
    public static void main(String args[]) {
	int r = Integer.parseInt(args[0]);
	long trials = Integer.parseInt(args[1]);
	double totalSteps = 0;
	double rand;
	int x,y;
	double steps;
	
	for(int i = 0; i < trials; i++) {
	    x = 0;
	    y = 0;
	    steps = 0;
	    while(Math.abs(x) + Math.abs(y) != r) {
		rand = Math.random();
		if(rand < 0.25) x += 1;
		else if(rand >= 0.25 && rand < 0.5) x -= 1;
		else if(rand >= 0.5 && rand < 0.75) y += 1;
		else y -= 1;
		steps += 1;
	    }
	    totalSteps += steps;
	}
	double average = totalSteps/trials;
	System.out.println("average number of steps = "+ average);
    }
}
