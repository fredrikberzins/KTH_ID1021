public class Benchmark {
    public static void main(String[] arg) {
    int fixedSize = 800;
	int[] sizes = {100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%20s%20s%20s%20s\n", "n", "List Fixed B", "list Fixed A", "Array Fixed A", "Array Fixed B");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int[][] array2dOrgi = Inital.array2d(loop, n);
			System.out.printf("%6d", n);
			int k = 1000;
			
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dOrgi.length; j++) {
					sort.selection(array2dOrgi[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dOrgi.length; j++) {
					sort.insert(array2dOrgi[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dOrgi.length; j++) {
					sort.merge(array2dOrgi[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dOrgi.length; j++) {
					sort.lowCopyMerge(array2dOrgi[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)\n" , (min/(loop)),((min/(loop))/(n)));
		}
    }
}