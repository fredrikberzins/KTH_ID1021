public class Heap_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {15/*100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200, 6400*/};
		/*--*/System.out.printf("# time in ns\n");
		/*--*/System.out.printf("%5s%27s%37s%37s%57s\n", "", "List Add", "List Remove", "Array", "Tree");
		/*--*/System.out.printf("%4s|%18s%18s|%18s%18s|%18s%18s|%18s%18s%18s%18s\n", "n", "Add", "Remove", "Add", "Remove", "Add", "Remove", "Add", "Remove", "Sum", "Push");
		for ( int n : sizes) {
			System.gc();
			int k = 1;
			
			int[] Arr = Heap_inital.Unsorted(n);

			/*--*/System.out.printf("%4d|", n);

			double addMin = Double.POSITIVE_INFINITY;
			double removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Heap_ListAdd listAdd = new Heap_ListAdd();
				long addT0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					listAdd.add(Arr[m]);
				}
				long addT1 = System.nanoTime();
				double addT = (addT1 - addT0);
				if(addT < addMin) addMin = addT;
				
				long removeT0 = System.nanoTime();
				while(!listAdd.empty()) {
					listAdd.remove();
				}
				long removeT1 = System.nanoTime();
				double removeT = (removeT1 - removeT0);
				if(removeT < removeMin) removeMin = removeT;
			}
			/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*100)));
			/*--*/System.out.printf("%12.0f(%4.1f)|", (removeMin), (removeMin/(n*n*10)));

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Heap_ListRemove listRemove = new Heap_ListRemove();
				long addT0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					listRemove.add(Arr[m]);
				}
				long addT1 = System.nanoTime();
				double addT = (addT1 - addT0);
				if(addT < addMin) addMin = addT;
				
				long removeT0 = System.nanoTime();
				while(!listRemove.empty()) {
					listRemove.remove();
				}
				long removeT1 = System.nanoTime();
				double removeT = (removeT1 - removeT0);
				if(removeT < removeMin) removeMin = removeT;
			}
			/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*n)));
			/*--*/System.out.printf("%12.0f(%4.1f)|", (removeMin), (removeMin/(n*100)));

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Heap_Array array = new Heap_Array();
				long addT0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					array.add(Arr[m]);
				}
				long addT1 = System.nanoTime();
				double addT = (addT1 - addT0);
				if(addT < addMin) addMin = addT;
				
				long removeT0 = System.nanoTime();
				while(!array.empty()) {
					array.remove();
				}
				long removeT1 = System.nanoTime();
				double removeT = (removeT1 - removeT0);
				if(removeT < removeMin) removeMin = removeT;
			}
			/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*Math.log(n)*100)));
			/*--*/System.out.printf("%12.0f(%4.1f)|", (removeMin), (removeMin/(n*Math.log(n)*100)));

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Heap_Tree tree = new Heap_Tree();
				long addT0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					tree.enqueue(Arr[m]);
				}
				long addT1 = System.nanoTime();
				double addT = (addT1 - addT0);
				if(addT < addMin) addMin = addT;
				
				long removeT0 = System.nanoTime();
				int num = 0;
				while(!tree.empty()) {
					tree.dequeue();
				}
				tree.TreePrinter();
				long removeT1 = System.nanoTime();
				double removeT = (removeT1 - removeT0);
				if(removeT < removeMin) removeMin = removeT;
			}
			/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*100)));
			/*--*/System.out.printf("%12.0f(%4.1f)", (removeMin), (removeMin/(Math.log(n)*10)));
			/*--*/System.out.printf("%12.0f(%4.1f)", (addMin+removeMin), ((addMin+removeMin)/(n*Math.log(n)*10)));

			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				Heap_Tree tree = new Heap_Tree();
				for (int m = 0; m < Arr.length; m++) {
					tree.enqueue(Arr[m]);
				}
				Arr = Heap_inital.Unsorted(n);
				long t0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					tree.Push(Arr[m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if(t < min) min = t;
			}
			/*--*/System.out.printf("%12.0f(%4.1f)\n", (min), (min/(n*10)));
		}
    }
}