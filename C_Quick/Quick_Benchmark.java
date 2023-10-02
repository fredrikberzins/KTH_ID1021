public class Quick_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {5,10/*100,200,100,200,100,200,400,800,1600,3200,6400*/};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%15s%15s\n", "n", "Array", "LinkedList");
		for ( int n : sizes) {
			System.gc();
			int loop = 2;
			int k = 2;

			int[][] Arr = Quick_Inital.Unsorted2d(loop, n);
			Quick_LinkedList[] LinkList = Quick_LinkedList.LinkedListArr(Arr);

			System.out.println("prerun: ");
			for (int m = 0; m < loop; m++) {
				System.out.println("begin array: ");
				for (int j = 0; j < n; j++) {
					System.out.println("valeu: " + Arr[m][j]);
				}
			}

			for (int m = 0; m < loop; m++) {
					System.out.println("begin list: ");
					Quick_Node qn = LinkList[m].first;
					while (qn != null) {
						System.out.println("valeu: " + qn.value);
						qn = qn.next;
					}
				}

			System.out.printf("%5d", n);

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] ArrCopy = Arr;
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					Quick_Inital.QuickSortArr(ArrCopy[m], 0, (ArrCopy[m].length-1));
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
				System.out.println("rerun: ");
				for (int m = 0; m < loop; m++) {
					System.out.println("new array: ");
					for (int j = 0; j < n; j++) {
						System.out.println("valeu: " + ArrCopy[m][j]);
					}
				}
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop*1000)),((min/(loop))/(10*n*Math.log(n))));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Quick_LinkedList[] LinkListCopy = LinkList;
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
					Quick_LinkedList.QuickSortList(LinkListCopy[m].first, LinkListCopy[m].end);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
				System.out.println("rerun: ");
				for (int m = 0; m < loop; m++) {
					System.out.println("new list: ");
					Quick_Node qn = LinkListCopy[m].first;
					while (qn != null) {
						System.out.println("valeu: " + qn.value);
						qn = qn.next;
					}
				}
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/(loop*1000)),((min/(loop))/(n*n)));	
		}
    }
}