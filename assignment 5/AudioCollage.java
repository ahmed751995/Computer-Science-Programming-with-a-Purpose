public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
	double[] n = new double[a.length];
	for (int i = 0; i < a.length; i++) {
	    if (a[i] * alpha > 1)
		n[i] = 1;
	    else if (a[i] * alpha < -1)
		n[i] = -1;
	    else n[i] = a[i] * alpha;
	}
	return n;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
	double[] n = new double[a.length];
	for (int i = 0; i < a.length; i++) {
	    n[i] = a[a.length - i - 1];
	}
	return n;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
	double[] n = new double[a.length + b.length];

	for (int i = 0; i < a.length; i++) {
	    n[i] = a[i];
	}
	for (int i = 0; i < b.length; i++) {
	    n[a.length + i] = b[i];
	}

	return n;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
	double[] n;
	double[] bigger;
	int smaller;
	if (a.length > b.length) {
	    n = new double[a.length];
	    smaller = b.length;
	    bigger = a;
	}
	else {
	    n = new double[b.length];
	    smaller = a.length;
	    bigger = b;
	}

	for (int i = 0; i < smaller; i++) {
	    n[i] = a[i] + b[i];
	}

	for (int i = smaller; i < bigger.length; i++) {
	    n[i] = bigger[i];
	}

	return n;
    }
    
    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
	double[] n = new double[(int) (a.length/alpha)];

	for (int i = 0; i < n.length; i++) {
	    n[i] = a[(int) (i * alpha)];
	}

	return n;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
	double[] a = StdAudio.read("./beatbox.wav");
	double[] b = StdAudio.read("./piano.wav");
	double[] c = StdAudio.read("./chimes.wav");
	double[] d = StdAudio.read("./scratch.wav");
	double[] e = StdAudio.read("./singer.wav");
	double alpha = 1.5;

	double[] n = merge(a, merge(b,c));
	n = amplify(n, alpha);
	n = reverse(n);
	n = mix(n, mix(d, e));
	n = changeSpeed(n, alpha);
	StdAudio.play(n);
    }
}
