public class Heap_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {100, 200, 100, 200, 100, 200, 400, 800, 1600, 3200, 6400, 12800};
		/*--*/System.out.printf("# time in ns\n");
		/*--*/System.out.printf("%6s%30s%40s%40s%40s\n", "", "List Add", "List Remove", "Array", "Tree");
		/*--*/System.out.printf("%5s|%20s%19s|%20s%19s|%20s%19s|%20s%20s\n", "n", "Add", "Remove", "Add", "Remove", "Add", "Remove", "Add", "Remove");
		for ( int n : sizes) {
			n= n/10;
			System.gc();
			int k = 2;
			
			Integer[] Arr = Heap_inital.Unsorted2d(n);
			//--Heap_Tree tree = new Heap_Tree();

			/*--*/System.out.printf("%5d|", n);

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
			/*--*/System.out.printf("%15.0f(%3.1f)", (addMin), (addMin/(n*100)));
			/*--*/System.out.printf("%14.0f(%3.1f)|", (removeMin), (removeMin/(n*n*100)));

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
			/*--*/System.out.printf("%15.0f(%3.1f)", (addMin), (addMin/(n*n*10)));
			/*--*/System.out.printf("%14.0f(%3.1f)|", (removeMin), (removeMin/(n*100)));

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			addMin = 0;
			removeMin = 0;
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
			/*--*/System.out.printf("%15.0f(%3.1f)", (addMin), (addMin/(n)));
			/*--*/System.out.printf("%14.0f(%3.1f)|", (removeMin), (removeMin/(n)));

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			addMin = 0;
			removeMin = 0;
			/*for (int i = 0; i < k; i++) {
				Heap_Tree tree = new Heap_Tree();
				long addT0 = System.nanoTime();
				for (int m = 0; m < Arr.length; m++) {
					tree.add(Arr[m]);
				}
				long addT1 = System.nanoTime();
				double addT = (addT1 - addT0);
				if(addT < addMin) addMin = addT;
				
				long removeT0 = System.nanoTime();
				while(!tree.empty()) {
					tree.remove();
				}
				long removeT1 = System.nanoTime();
				double removeT = (removeT1 - removeT0);
				if(removeT < removeMin) removeMin = removeT;
			}*/
			/*--*/System.out.printf("%15.0f(%3.1f)", (addMin), (addMin/(n)));
			/*--*/System.out.printf("%15.0f(%3.1f)\n", (removeMin), (removeMin/(n)));
		}
    }
}