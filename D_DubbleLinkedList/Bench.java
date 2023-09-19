public class Bench {
    public static void main(String[] arg) {
    int fixedSize = 800;
	int[] sizes = {100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400, 204800, 409600, 819200};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%15s%15s%15s%15s%15s%15s%15s%15s\n", "n", "L FixB", "L FixA", "A FixA", "A FixB", "L FixB(Build)", "L FixA(Build)", "A FixA(Build)", "A FixB(Build)");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 1000;
			int[][] ArrayA;
			int[] ArrayB;
			DubbleList[] listAArray;
			DubbleList listB;
			System.out.printf("%6d", n);
			// List Fixed B
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				listAArray = Ini.list2d(loop, n);
				listB = new DubbleList(fixedSize);
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					listAArray[m].append(listB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*n)));
			// List Fixed A
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				listAArray = Ini.list2d(loop, fixedSize);
				listB = new DubbleList(n);
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					listAArray[m].append(listB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*fixedSize)));
			// Array Fixed B
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				ArrayA = Ini.array2d(loop,n);
				ArrayB = Ini.unsorted(fixedSize);
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					ArrayA[m] = Ini.append(ArrayA[m], ArrayB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*(n+fixedSize))));
			// Array Fixed A
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				ArrayA = Ini.array2d(loop, fixedSize);
				ArrayB = Ini.unsorted(n);
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					ArrayA[m] = Ini.append(ArrayA[m], ArrayB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*(n+fixedSize))));
			// List Fixed B (Build)
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				listAArray = Ini.list2d(loop, n);
				listB = new DubbleList(fixedSize);
				for (int m = 0; m < loop; m++) {
					listAArray[m].append(listB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*(n))));
			// List Fixed A (Build)
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				listAArray = Ini.list2d(loop, fixedSize);
				listB = new DubbleList(n);
				for (int m = 0; m < loop; m++) {
					listAArray[m].append(listB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*(fixedSize))));
			// Array Fixed B (Build)
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				ArrayA = Ini.array2d(loop, n);
				ArrayB = Ini.unsorted(fixedSize);
				for (int m = 0; m < loop; m++) {
					ArrayA[m] = Ini.append(ArrayA[m], ArrayB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)" , (min/loop),(min/(loop*(n))));
			// Array Fixed A (Build)
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				ArrayA = Ini.array2d(loop, fixedSize);
				ArrayB = Ini.unsorted(n);
				for (int m = 0; m < loop; m++) {
					ArrayA[m] = Ini.append(ArrayA[m], ArrayB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%9.0f(%4.1f)\n" , (min/loop),(min/(loop*(n))));
		}
    }
}