import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
	In in = new In(args[0]);
	int maxBars = Integer.parseInt(args[1]);
	String title = in.readLine();
	String xAxis = in.readLine();
	String source = in.readLine();
	BarChart chart = new BarChart(title, xAxis, source);
	String year = "";
	
	StdDraw.setCanvasSize(1000, 700);
	StdDraw.enableDoubleBuffering();

	String[] bar;

    	while(!in.isEmpty()) {
	    in.readLine();
    	    int barsNumber = Integer.parseInt(in.readLine());
    	    Bar[] bars = new Bar[barsNumber];

    	    for (int l = 0; l < barsNumber; l++) {
		String line = in.readLine();
    		bar = line.split(",");
    		bars[l] = new Bar(bar[1], Integer.parseInt(bar[3]), bar[4]);
    		year = bar[0];
    	    }
	    
    	    Arrays.sort(bars);

    	    for (int b = barsNumber - 1; b >= barsNumber - maxBars; b--) {
    	    	Bar newBar = bars[b];
    	    	chart.add(newBar.getName(), newBar.getValue(), newBar.getCategory());
    	    }

    	    chart.setCaption(year);
    	    chart.draw();
    	    StdDraw.show();
    	    chart.reset();
    	    StdDraw.clear();
    	    StdDraw.pause(20);
    	}
    }
}
