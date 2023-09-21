public class Bench {
    public static void main(String[] arg) {
    int fixedSize = 400;
	int[] sizes = {100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%20s%10s\n", "n", "Singel", "Dubble");
		for ( int n : sizes) {
			System.gc();
			int loop = 100;
			int k = 100;
			SingelList[] SlistAArray = Ini.SArray(loop, n);
			DoubleList[] DlistAArray = Ini.DArray(loop, n);
			SingelNode[][] SNodeArray = SingelList.SNodeArray2d(SlistAArray, fixedSize);
			DoubleNode[][] DNodeArray = DoubleList.DNodeArray2d(DlistAArray, fixedSize);
			System.out.printf("%6d", n);
			// Singel
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					for (int j = 0; j < SNodeArray[m].length; j++) {
						SlistAArray[m].unlink(SNodeArray[m][j]);
						SlistAArray[m].link(SNodeArray[m][j]);
					}
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
				for (int m = 0; m < loop; m++) {
					for (int j = 0; j < DNodeArray[m].length; j++) {
						DlistAArray[m].unlink(DNodeArray[m][j]);
						DlistAArray[m].link(DNodeArray[m][j]);
					}
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%10.0f\n" , (min/loop));
		}
    }
}