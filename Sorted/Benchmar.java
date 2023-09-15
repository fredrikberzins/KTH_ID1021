public class Benchmar {
    public static void main(String[] arg) {
	int[] sizes = {100,200,100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%15s%15s%15s%15s%15s%15s\n", "n", "linear", "Good_Lin", "Binary", "linear_DUP", "Good_Lin_DUP", "Binary_DUP");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			
			int[] sortedArraySearch = Inital.sorted_search(n);
			int[] sortedArrayDup = Inital.sorted_dup(n);
			int[] indx = Inital.keys(loop, n);
			int[][] sortedArray2D = Inital.array2d(loop, n);
			System.out.printf("%5d", n);
			int k = 1000;

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < indx.length; j++) {
					search.linear(sortedArraySearch, indx[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop),((min/(loop*k))/(n))*10000);

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < indx.length; j++) {
					search.betterLinear(sortedArraySearch, indx[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop),((min/(loop*k))/(n))*10000);	
			   
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < indx.length; j++) {
					search.binary(sortedArraySearch, indx[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop),((min/(loop*k))/(Math.log(n)))*100);	

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < sortedArray2D.length; j++) {
					duplicate.linear(sortedArrayDup, sortedArray2D[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop),((min/(loop*k))/(n*n))*10000);	

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < sortedArray2D.length; j++) {
					duplicate.betterLinear(sortedArrayDup, sortedArray2D[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/loop), ((min/(loop*k))/n)*1000);	

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < sortedArray2D.length; j++) {
					duplicate.binary(sortedArrayDup, sortedArray2D[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/loop),((min/(loop*k))/(n*Math.log(n)))*1000);	
		}
    }
}