public class Benchmark {
    private static void linearSearch(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			search.linear(array, indx[i]);
		}
    }
    private static void betterLinearSerch(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			search.betterLinear(array, i);
		}
    }
    private static void binarySearch(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			search.binary(array, indx[i]);
		}
    }

	private static void linearDuplicate(int[] array1, int[] array2, int loops) {
		for (int i = 0; i < loops ; i++) {
			duplicate.linear(array1, array2);
		}
    }
    private static void betterLinearDuplicate(int[] array1, int[] array2, int loops) {
		for (int i = 0; i < loops ; i++) {
			duplicate.binary(array1, array2);
		}
    }
	
    private static void binaryDuplicate(int[] array1, int[] array2, int loops) {
		for (int i = 0; i < loops ; i++) {
			duplicate.binary(array1, array2);
		}
    }
    
    public static void main(String[] arg) {
		int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%7s%12s%12s%12s%20s%20s%20s\n", "n", "linear", "BLinear", "Binary", "linear_DUP", "BLinear_DUP", "Binary_DUP");
		for ( int n : sizes) {
			int loop = 10000;
			
			int[] sortedArray = Inital.sorted(n);
			int[] indx = Inital.keys(loop, n);
			System.out.printf("%8d", n);
			int k = 1000;

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				linearSearch(sortedArray, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%12.0f", (min/loop));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				betterLinearSerch(sortedArray, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}
			System.out.printf("%12.0f", (min/loop));
			   
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			binarySearch(sortedArray, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}
			System.out.printf("%12.0f" , (min/loop));

			min = Double.POSITIVE_INFINITY;
			Double median = 0.0;
			Double max = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[] sortedArray2  = Inital.sorted(n);
				long t0 = System.nanoTime();
				linearDuplicate(sortedArray, sortedArray2, loop);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
				if(t > max) max = t;
			}
			System.out.printf("%6.0f/%6.0f/%6.0f" , (min/loop), (median/(k*loop)), (max/loop));	

			min = Double.POSITIVE_INFINITY;
			median = 0.0;
			max = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[] sortedArray2  = Inital.sorted(n);
				long t0 = System.nanoTime();
				betterLinearDuplicate(sortedArray, sortedArray2, loop);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
				if(t > max) max = t;
			}
			System.out.printf("%6.0f/%6.0f/%6.0f" , (min/loop), (median/(k*loop)), (max/loop));	

			min = Double.POSITIVE_INFINITY;
			median = 0.0;
			max = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[] sortedArray2 = Inital.sorted(n);
				long t0 = System.nanoTime();
				binaryDuplicate(sortedArray, sortedArray2, loop);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
				if(t > max) max = t;
			}
			System.out.printf("%6.0f/%6.0f/%6.0f\n" , (min/loop), (median/(k*loop)), (max/loop));	
		}
    }
}