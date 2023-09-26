public class Tree_Benchmark {
    public static void main(String[] arg) {
    	int fixedSize = 400;
		int[] sizes = {100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%20s\n", "n", "lookup");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 100;
			BinaryTree[] B = BinaryTree.BinaryTree2dArray(loop, n);
			int[][] keyArray = TreeNode.key2dArray(B, fixedSize);
			System.out.printf("%6d", n);
			// Singel
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < keyArray.length; m++) {
					for (int j = 0; j < keyArray[m].length; j++) {
						B[m].lookup(keyArray[m][j]);
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%15.0f(%3.1f)\n" , (min/loop),(min/(100*loop*(Math.log(n)))));
		}
    }
}