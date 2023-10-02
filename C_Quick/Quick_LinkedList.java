public class Quick_LinkedList {

    public static Quick_Node first;
    public static Quick_Node last;

    public Quick_LinkedList(int[] Arr) {
        first = new Quick_Node(Arr[0]);
        Quick_Node n = first;
		for (int i = 1; i < Arr.length; i++) {
			n.next = new Quick_Node(Arr[i]);
			n = n.next;
		}
        last = n;
    }

    public static Quick_LinkedList[] LinkedListArr(int[][] Arr) {
        Quick_LinkedList[] List2d = new Quick_LinkedList[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            List2d[i].first = new Quick_Node(Arr[i][0]);
            Quick_Node n = first;
            for (int m = 1; m < Arr[i].length; m++) {
                n.next = new Quick_Node(Arr[i][m]);
                n = n.next;
            }
            List2d[i].last = n;
        }
        return List2d;
    }

    public static void QuickSortList(Quick_Node lo, Quick_Node hi) {
        Quick_Node pivotNode = lo;

        if ( lo != hi) {
            int pivot = hi.value;
            Quick_Node curr = lo.next;

            while (curr != hi) {
                if (curr.value <= pivot) {
                    pivotNode = pivotNode.next;
                    swap(pivotNode, curr);
                }
                curr = curr.next;
            }
            swap(hi, pivotNode);
            QuickSortList(lo, pivotNode);
            QuickSortList(pivotNode.next, hi);
        }
    }
    public static void swap(Quick_Node a, Quick_Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

}