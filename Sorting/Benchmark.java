public class Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {100,200,100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%15s%15s%15s\n", "n", "selection", "insert", "merge");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int[][] array2d = Inital.array2d(loop, n);
			System.out.printf("%6d", n);
			int k = 1000;

			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2d.length; j++) {
					sort.selection(array2d[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n*n))*10);
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2d.length; j++) {
					sort.insert(array2d[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n*n))*10);

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2d.length; j++) {
					sort.merge(array2d[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/(loop)),((min/(loop))/(n*Math.log(n))));
		}
    }
}