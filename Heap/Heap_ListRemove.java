public class Heap_ListRemove {
    private Heap_Node first;

    public Heap_ListRemove() {
        this.first = null;
    }

    public static Heap_ListRemove[] LinkedListArr(int[][] Arr) {
        Heap_ListRemove[] List2d = new Heap_ListRemove[Arr.length];
        for (int i = 0; i < List2d.length; i++) {
            List2d[i] = new Heap_ListRemove();
            if (Arr[i].length == 0) {
                List2d[i].first = null;
            }
            else {
                List2d[i].first = new Heap_Node(Arr[i][0]);
                Heap_Node n = List2d[i].first;
                for (int m = 1; m < Arr[i].length; m++) {
                    List2d[i].add(Arr[i][m]);
                }
            }
        }
        return List2d;
    }

    public void add(int value) {
        Heap_Node n = first;
        Heap_Node u = new Heap_Node(value);
        if (n.value > value) {
            u.next = n;
            first = u.next;
        }
        while (n.next != null) {
            if (n.next.value > value) {
                u.next = n.next.next;
                n.next = u;
            }
            n = n.next;
        }
    }
    
    public boolean find(int value) {
        Heap_Node n = first;
        while (n != null) {
            if (n.value == value) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public Heap_Node remove() {
        Heap_Node n = first;
        first = n.next;
        return n;
    }
}