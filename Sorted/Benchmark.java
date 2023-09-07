public class Benchmark {
    private static void linearSearch(int[] array, int[] keys) {
		for (int i = 0; i < keys.length ; i++) {
			search.linear(array, keys[i]);
		}
    }
    private static void betterLinearSerch(int[] array, int[] keys) {
		for (int i = 0; i < keys.length ; i++) {
			search.betterLinear(array, keys[i]);
		}
    }
    private static void binarySearch(int[] array, int[] keys) {
		for (int i = 0; i < keys.length ; i++) {
			search.binary(array, keys[i]);
		}
    }

	private static void linearDuplicate(int[] array1, int[][] array2) {
		for (int i = 0; i < array2.length ; i++) {
			duplicate.linear(array1, array2[i]);
		}
    }
    private static void betterLinearDuplicate(int[] array1, int[][] array2) {
		for (int i = 0; i < array2.length; i++) {
			duplicate.betterLinear(array1, array2[i]);
		}
    }
    private static void binaryDuplicate(int[] array1, int[][] array2) {
		for (int i = 0; i < array2.length ; i++) {
			duplicate.binary(array1, array2[i]);
		}
    }
    
    public static void main(String[] arg) {
		int[] sizes = {100,200,400,800,1600};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%6s%6s%6s%19s%18s%18s\n", "n", "lin", "BLin", "Bin", "linear_DUP", "BLinear_DUP", "Binary_DUP");
		for ( int n : sizes) {
			int loop = 10000;
			
			int[] sortedArray = Inital.sorted(n);
			int[] indx = Inital.keys(loop, n);
			int[][] sortedArray2D = Inital.array2d(loop, n);
			System.out.printf("%5d", n);
			int k = 1000;

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				linearSearch(sortedArray, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%6.0f", (min/loop));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				betterLinearSerch(sortedArray, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%6.0f", (min/loop));
			   
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				binarySearch(sortedArray, indx);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%6.0f" , (min/loop));

			min = Double.POSITIVE_INFINITY;
			Double median = 0.0;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				linearDuplicate(sortedArray, sortedArray2D);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
			}
			System.out.printf("%7.0f/%5.0f(%4.1f)" , (min/loop), (median/(loop*k)),((median/(loop*k))/(n*n))*100);	

			min = Double.POSITIVE_INFINITY;
			median = 0.0;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				betterLinearDuplicate(sortedArray, sortedArray2D);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
			}
			System.out.printf("%7.0f/%5.0f(%3.1f)" , (min/loop), (median/(loop*k)),((median/(loop*k))/n));	

			min = Double.POSITIVE_INFINITY;
			median = 0.0;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				binaryDuplicate(sortedArray, sortedArray2D);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
				median += t;
			}
			System.out.printf("%7.0f/%5.0f(%3.1f)\n" , (min/loop), (median/(loop*k)),((median/(loop*k))/(n*Math.log(n))));	
		}
    }
}