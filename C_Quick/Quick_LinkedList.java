import java.util.List;
import java.util.Random;

public class Quick_LinkedList {

    private class Node {
        public int value;
        public Node next;
    
        public Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node first;

    public Quick_LinkedList(int[] Arr) {
        Random rnd = new Random();
        first = new Node(Arr[0]);
        Node n = first;
		for (int i = 1; i < Arr.length; i++) {
			n.next = new Node(Arr[i]);
			n = n.next;
		}
    }

    public Quick_LinkedList[] Quick_LinkedListArr(int[][] Arr) {
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

    public Quick_Sort() {
        
    }
}