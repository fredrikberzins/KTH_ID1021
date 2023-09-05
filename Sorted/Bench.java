class Bench {
    private static void linear(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			Linear.search(array, indx[i]);
		}
    }
    private static void binary(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			Binary.search(array, indx[i]);
		}
    }
    
    public static void main(String[] arg) {
		int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
		for ( int n : sizes) {
			int loop = 10000;
			
			int[] array = Inital.sorted(n);
			int[] indx = Inital.keys(loop, n);
			System.out.printf("%8d", n);

			int k = 1000;	
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				linear(array, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%8.0f", (min/loop));
			   
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			binary(array, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}

			System.out.printf("%8.0f\n" , (min/loop));	    	    
		}
    }
}