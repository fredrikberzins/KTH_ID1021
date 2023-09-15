public class Benchma {
    public static void main(String[] arg) {
	int[] sizes = {100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%15s%15s%15s%15s\n", "n", "selection", "insert", "merge", "lowCopyMerge");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int[][] array2dOrgi = Inital.array2d(loop, n);
			System.out.printf("%6d", n);
			int k = 1000;
			
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] array2dSection = Inital.copyArr2d(array2dOrgi);
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dSection.length; j++) {
					sort.selection(array2dSection[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n*n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] array2dInsert = Inital.copyArr2d(array2dOrgi);
				
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dInsert.length; j++) {
					sort.insert(array2dInsert[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n*n))*10);
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] array2dMerge = Inital.copyArr2d(array2dOrgi);
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dMerge.length; j++) {
					sort.merge(array2dMerge[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n*Math.log(n)))/10);
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] array2dLowCopyMerge = Inital.copyArr2d(array2dOrgi);
				long t0 = System.nanoTime();
				for (int j = 0; j < array2dLowCopyMerge.length; j++) {
					sort.lowCopyMerge(array2dLowCopyMerge[j]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/(loop)),((min/(loop))/(n*Math.log(n)))/10);
		}
    }
}