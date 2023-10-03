public class Queue_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {100, 200, 400, 100, 200, 400, 100, 200, 400, 800, 1600, 3200,6400, 12800, 25600, 51200, 102400, 204800, 409600};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%6s%25s%25s%25s%25s\n", "n", "Array", "Array large", "Queue Singel", "Queue Dual");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 1000;

			Queue_Array<Integer> arr;
			Queue_Array<Integer> arrLarge;

            Queue_Simple<Integer> sim;
			Queue_Last<Integer> last;

			System.out.printf("%7d", n);
			Double min = Double.POSITIVE_INFINITY;
			arr = new Queue_Array<Integer>();
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < loop; j++) {
					arr = new Queue_Array<Integer>();
					for (int m = 0; m < n; m++) {
						arr.add(m);
					}
					for (int m = 0; m < n; m++) {
						arr.remove();
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%19.0f(%4.1f)", (min/loop),((min/loop)/(n*10)));

			min = Double.POSITIVE_INFINITY;
			arrLarge = new Queue_Array<Integer>(n*2);
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < loop; j++) {
					arrLarge = new Queue_Array<Integer>(n*2);
					for (int m = 0; m < n; m++) {
						arrLarge.add(m);
					}
					for (int m = 0; m < n; m++) {
						arrLarge.remove();
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%19.0f(%4.1f)", (min/loop),((min/loop)/(n*10)));


			min = Double.POSITIVE_INFINITY;
			sim = new Queue_Simple<Integer>();
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < loop; j++) {
					sim = new Queue_Simple<Integer>();
					for (int m = 0; m < n; m++) {
						sim.add(m);
					}
					for (int m = 0; m < n; m++) {
						sim.remove();
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%19.0f(%4.1f)", (min/loop),((min/loop)/(n*n+n)));


			min = Double.POSITIVE_INFINITY;
			last = new Queue_Last<Integer>();
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < loop; j++) {
					last = new Queue_Last<Integer>();
					for (int m = 0; m < n; m++) {
						last.add(m);
					}
					for (int m = 0; m < n; m++) {
						last.remove();
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%19.0f(%4.1f)\n", (min/loop),((min/loop)/(n*10)));	
		}
    }
}