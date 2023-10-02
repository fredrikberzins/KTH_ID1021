public class Queue_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {100,200,100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%15s%15s%15s\n", "n", "Array", "Linked List");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 1000;
            
			System.out.printf("%5d", n);
			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();

				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop),((min/(loop))/(n)));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();

				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/loop),((min/(loop))/(n*Math.log(n))));	
		}
    }
}