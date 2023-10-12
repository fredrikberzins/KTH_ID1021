public class Heap_Benchmark {
    public static void main(String[] arg) {
	int[] sizes = {100, 200, 400, 100, 200, 400, 100, 200, 400,/*To start*/ 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};
		/*--*/System.out.printf("# time in ns\n");
		/*--*/System.out.printf("%6s%37s%58s%58s%64s\n", "", "List Add", "List Remove", "Array", "Tree");
		/*--*/System.out.printf("%5s |%16s%20s%20s |%20s%16s%20s |%18s%18s%20s |%18s%18s%18s%18s\n", "n", "Add", "Remove", "Sum", "Add", "Remove", "Sum", "Add", "Remove", "Sum", "Add", "Remove", "Sum", "Push");
		for (int j = 0; j < sizes.length; j++) {
			int n = sizes[j];
			int print_index = 8;
			System.gc();
			int k = 10;
			int loop = 10;
			
			int[][] Arr = Heap_inital.Unsorted2d(loop, n);
			if (j > print_index) {
				/*--*/System.out.printf("%5d |", n);
			}

			double addMin = Double.POSITIVE_INFINITY;
			double removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				for (int z = 0; z < Arr.length; z++) {
					Heap_ListAdd listAdd = new Heap_ListAdd();
					long addT0 = System.nanoTime();
					for (int m = 0; m < Arr[z].length; m++) {
						listAdd.add(Arr[z][m]);
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
			}
			if (j > print_index) {
				/*--*/System.out.printf("%10.0f(%4.1f)", (addMin), (addMin/(n)));
				/*--*/System.out.printf("%14.0f(%4.1f)", (removeMin), (removeMin/(n*n)));
				/*--*/System.out.printf("%14.0f(%4.1f) |", ((addMin+removeMin)), ((addMin+removeMin)/(n*n)));
			}

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				for (int z = 0; z < Arr.length; z++) {
					Heap_ListRemove listRemove = new Heap_ListRemove();
					long addT0 = System.nanoTime();
					for (int m = 0; m < Arr[z].length; m++) {
						listRemove.add(Arr[z][m]);
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
			}
			if (j > print_index) {
				/*--*/System.out.printf("%14.0f(%4.1f)", (addMin), (addMin/(n*n)));
				/*--*/System.out.printf("%10.0f(%4.1f)", (removeMin), (removeMin/(n)));
				/*--*/System.out.printf("%14.0f(%4.1f) |", ((addMin+removeMin)), ((addMin+removeMin)/(n*n)));
			}

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				for (int z = 0; z < Arr.length; z++) {
					Heap_Array array = new Heap_Array();
					long addT0 = System.nanoTime();
					for (int m = 0; m < Arr[z].length; m++) {
						array.add(Arr[z][m]);
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
			}
			if (j > print_index) {
				/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*Math.log(n))));
				/*--*/System.out.printf("%12.0f(%4.1f)", (removeMin), (removeMin/(n*Math.log(n)*10)));
				/*--*/System.out.printf("%14.0f(%4.1f) |", ((addMin+removeMin)), ((addMin+removeMin)/(n*Math.log(n)*10)));
			}

			addMin = Double.POSITIVE_INFINITY;
			removeMin = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				for (int z = 0; z < Arr.length; z++) {
					Heap_Tree tree = new Heap_Tree();
					long addT0 = System.nanoTime();
					for (int m = 0; m < Arr[z].length; m++) {
						tree.add(Arr[z][m]);
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
				}
			}
			if (j > print_index) {
				/*--*/System.out.printf("%12.0f(%4.1f)", (addMin), (addMin/(n*Math.log(n))));
				/*--*/System.out.printf("%12.0f(%4.1f)", (removeMin), (removeMin/(n*n*0.1)));
				/*--*/System.out.printf("%14.0f(%4.1f)", ((addMin+removeMin)), ((addMin+removeMin)/(n*n*10)));
			}
			double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] inc = Heap_inital.Unsorted2d(loop, n);
				for (int z = 0; z < Arr.length; z++) {
					Heap_Tree tree = new Heap_Tree();
					for (int m = 0; m < Arr[z].length; m++) {
						tree.add(Arr[z][m]);
					}
					long t0 = System.nanoTime();
					for (int m = 0; m < inc[z].length; m++) {
						tree.push(inc[z][m]);
					}
					long t1 = System.nanoTime();
					double t = (t1 - t0);
					if(t < min) min = t;
				}
			}
			if (j > print_index) {
				/*--*/System.out.printf("%12.0f(%4.1f)\n", (min), (min/(n*Math.log(n))));
			}
		}
    }
}