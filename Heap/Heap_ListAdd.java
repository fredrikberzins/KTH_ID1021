public class Heap_ListAdd {
    private Heap_Node first;

    public Heap_ListAdd() {
        this.first = null;
    }

    public static Heap_ListAdd[] LinkedListArr(int[][] Arr) {
        Heap_ListAdd[] List2d = new Heap_ListAdd[Arr.length];
        for (int i = 0; i < List2d.length; i++) {
            List2d[i] = new Heap_ListAdd();
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

    public void add(int item) {
        Heap_Node n = new Heap_Node(item);
        n.next = first;
        first = n;
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
        Heap_Node u = first;
        while (n != null) {
            if (n.value < u.value) {
                u = n;
            }
            n = n.next;
        }
        return u;
    }
}