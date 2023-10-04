public class Quick_LinkedList {

    public Quick_Node first;
    public Quick_Node last;

    public Quick_LinkedList() {
        this.first = new Quick_Node();
        Quick_Node n = this.first;
        this.last = n;
    }

    public static Quick_LinkedList[] LinkedListArr(int[][] Arr) {
        Quick_LinkedList[] List2d = new Quick_LinkedList[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            List2d[i] = new Quick_LinkedList();
            Quick_Node n = new Quick_Node();
            n = List2d[i].first;
            n.value = Arr[i][0];
            for (int m = 1; m < Arr[i].length; m++) {
                n.next = new Quick_Node();
                n.next.value = Arr[i][m];
                n = n.next;
            }
            List2d[i].last = n;
        }
        return List2d;
    }

    public static void QuickSortList(Quick_Node lo, Quick_Node hi) {
        if (lo != hi) {
            int pivotValue = hi.value;
            Quick_Node curr = lo.next;
            Quick_Node pivot = lo;

            while (curr != hi) {
                if (curr.value <= pivotValue) {
                    pivot = pivot.next;
                    swap(pivot, curr);
                }
                curr = curr.next;
            }
            swap(pivot.next, hi);
            QuickSortList(lo, pivot);
            QuickSortList(pivot.next, hi);
        }
    }
    public static void swap(Quick_Node a, Quick_Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}