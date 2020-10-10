import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    private static Picture general(Picture picture, int[][] kernel, double constant) {
	int width = picture.width();
    	int height = picture.height();
	// StdOut.println("width height " + width + " " + height);
    	Picture result = new Picture(width, height);
    	Color color;
	double red, green, blue;
    	for (int c = 0; c < width; c++) {
    	    for (int r = 0; r < height; r++) {
		int start_c = c - kernel.length / 2;
		int start_r = r - kernel.length / 2;
		// StdOut.println("start_c, start_r = "+ start_c + " " + start_r);
		red = 0;
		green = 0;
		blue = 0;
		// sum = 0;
		for (int kc = 0; kc < kernel.length; kc++) {
		    for (int kr = 0; kr < kernel.length; kr++) {
			int v_c = (width + start_c + kc) % width;
			int v_r = (height + start_r + kr) % height;
			// StdOut.print("v_c, v_r = " + v_c + " " + v_r + " ");
			color = picture.get(v_c, v_r);
			red += color.getRed() * kernel[kc][kr] * constant;
			green += color.getGreen() * kernel[kc][kr] * constant;
			blue += color.getBlue() * kernel[kc][kr] * constant;
			// StdOut.println("color = " + red + " " + green + " " + blue);
		    }
		    // StdOut.println();
		    
		}
		if (red < 0) red = 0;
		else if (red > 255) red = 255;

		if (green < 0) green = 0;
		else if (green > 255) green = 255;

		if (blue < 0) blue = 0;
		else if (blue > 255) blue = 255;
		int nred = (int) Math.round(red);
		int ngreen = (int) Math.round(green);
		int nblue = (int) Math.round(blue);
		Color new_color = new Color(nred, ngreen, nblue);
		result.set(c, r, new_color);
    	    }
    	}
	return result;
    }
    
    public static Picture identity(Picture picture) {
    	int[][] kernel = {{0, 0, 0},
			  {0, 1, 0},
			  {0, 0, 0}};
	double constant = 1;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
	int[][] kernel = {{1, 2, 1},
			  {2, 4, 2},
			  {1, 2, 1}};
	double constant = 1.0/16.0;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
	int[][] kernel = {{0, -1, 0},
			  {-1, 5, -1},
			  {0, -1, 0}};
	double constant = 1;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
	int[][] kernel = {{-1, -1, -1},
			  {-1, 8, -1},
			  {-1, -1, -1}};
	double constant = 1;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
	int[][] kernel = {{-2, -1, 0},
			  {-1, 1, 1},
			  {0, 1, 2}};
	double constant = 1;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
	int[][] kernel = {{1, 0, 0, 0, 0, 0, 0, 0, 0},
			  {0, 1, 0, 0, 0, 0, 0, 0, 0},
			  {0, 0, 1, 0, 0, 0, 0, 0, 0},
			  {0, 0, 0, 1, 0, 0, 0, 0, 0},
			  {0, 0, 0, 0, 1, 0, 0, 0, 0},
			  {0, 0, 0, 0, 0, 1, 0, 0, 0},
			  {0, 0, 0, 0, 0, 0, 1, 0, 0},
			  {0, 0, 0, 0, 0, 0, 0, 1, 0},
			  {0, 0, 0, 0, 0, 0, 0, 0, 1}};
	double constant = 1.0/9.0;
	Picture result = general(picture, kernel, constant);
	return result;
    }

    // Test client (ungraded).
	public static void main(String[] args) {
	    Picture pic = new Picture(args[0]);
	    Picture idenPic = identity(pic);
	    idenPic.show();
	    Picture gausPic = gaussian(pic);
	    gausPic.show();
	    Picture sharpPic = sharpen(pic);
	    sharpPic.show();
	    Picture lapPic = laplacian(pic);
	    lapPic.show();
	    Picture embPic = emboss(pic);
	    embPic.show();
	    Picture blurPic = motionBlur(pic);
	    blurPic.show();
	}
}
