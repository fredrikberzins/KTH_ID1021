public class Benchm {
    public static void main(String[] arg) {
    int fixedSize = 800;
	int[] sizes = {100,200,100,200,400,800,1600,3200,6400};
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("#%5s%20s%20s%20s%20s\n", "n", "List Fixed B", "list Fixed A", "Array Fixed A", "Array Fixed B");
		for ( int n : sizes) {
			System.gc();
			int loop = 5;
			int k = 5;
			LinkedList[] listAArray = new LinkedList[loop];
			for (int i = 0; i < loop; i++) {
				listAArray[i] = new LinkedList(n);
			}
			LinkedList listB = new LinkedList(fixedSize);
			System.out.printf("%6d", n);
			
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < listAArray.length; m++) {
					listAArray[m].append(listB);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			LinkedList listA = new LinkedList(fixedSize);
			LinkedList[] listBArray = new LinkedList[loop];
			for (int i = 0; i < loop; i++) {
				listBArray[i] = new LinkedList(n);
			}

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < listBArray.length; m++) {
					listBArray[m].append(listA);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < array2dOrgi.length; m++) {
					//sort.merge(array2dOrgi[m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)" , (min/(loop)),((min/(loop))/(n)));
			
			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < array2dOrgi.length; m++) {
					//sort.lowCopyMerge(array2dOrgi[m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			System.out.printf("%20.0f(%3.1f)\n" , (min/(loop)),((min/(loop))/(n)));
		}
    }
}