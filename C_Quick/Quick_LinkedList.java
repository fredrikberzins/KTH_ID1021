import java.util.Random;

public class Quick_LinkedList {

    private class Node {
        private int value;
        private Node next;
    
        public Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public Node first;
    public Node end;

    public Quick_LinkedList(int[] Arr) {
        Random rnd = new Random();
        first = new Node(Arr[0]);
        Node n = first;
		for (int i = 1; i < Arr.length; i++) {
			n.next = new Node(Arr[i]);
			n = n.next;
		}
        Node end = n;
    }

    public static Quick_LinkedList[] LinkedListArr(int[][] Arr) {
        Random rnd = new Random();
        Quick_LinkedList[] List2d = new Quick_LinkedList[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            List2d[i].first = new Node(Arr[i][0]);
            Node n = first;
            for (int m = 1; m < Arr.length; m++) {
                n.next = new Node(Arr[i][m]);
                n = n.next;
            }
        }
        return List2d;
    }

    public static void QuickSortList(Node lo, Node hi) {
        Node pivotNode = lo;

        if ( lo == hi) {
            int pivot = hi.value;
            Node curr = lo.next;

            while (curr != hi) {
                if (curr.value < pivot) {
                    pivotNode = pivotNode.next;
                    swap(pivotNode, curr);
                }
                curr = curr.next;
            }
            swap(hi, pivotNode);
        }
        QuickSortList(lo, pivotNode);
        QuickSortList(pivotNode.next, hi);
    }
    public static void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

}