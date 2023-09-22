import java.util.Random;

public class Tree_Benchmark {
    public static void main(String[] arg) {
		Random rnd = new Random();
		int[] sizes = {100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%20s%10s\n", "n", "first", "second");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 1000;
			BinaryTree[] B = new BinaryTree2dArray();
			int[][] keyArray = new key2dArray(B);
			for (int i = 0,j = 0; i < n; i++) {
				int m = rnd.nextInt(n*10);
				B.add(m, i);
			}
			System.out.printf("%6d", n);
			// Singel
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < keyArray.length; m++) {
					B.lookup(keyArray[m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%15.0f(%3.1f)" , (min/loop),(min/(loop*n*1000)));
			// Dubble
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				// inner
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f\n" , (min/loop));
		}
    }
}