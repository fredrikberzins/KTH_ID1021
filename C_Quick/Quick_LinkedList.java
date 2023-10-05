public class Quick_LinkedList {

    public Quick_Node first;
    public Quick_Node last;

    public Quick_LinkedList() {
        this.first = null;
        this.last = null;
    }

    private void add(int val) {
        Quick_Node n = new Quick_Node(val, this.first);
        if (this.last == null) {
            this.last = n;
        }
        this.first = n;
    }

    public void append (Quick_LinkedList tail) {
        if (tail != null) {
            if (this.last != null) {
                this.last.next = tail.last;
            } else {
                this.first = tail.first;
            }
            if (tail.last != null) {
                this.last  = tail.last;
            }
            tail.first = null;
            tail.last = null;
        }
    }

    public void prepend (Quick_LinkedList head) {
        if (head != null) {
            if (head.last != null) {
                head.last.next = this.first;
            }
            if (this.last == null) {
                this.last = head.last;
            }
            if (head.first != null) {
                this.first = head.first;
            }
            head.first = null;
            head.last = null;
        }
    }

    private void add(Quick_Node n) {
        if (this.last == null) {
            this.last = n;
        }
        n.next = this.first;
        this.first = n;
    }


    public static Quick_LinkedList[] LinkedListArr(int[][] Arr) {
        Quick_LinkedList[] List2d = new Quick_LinkedList[Arr.length];
        for (int i = 0; i < List2d.length; i++) {
            List2d[i] = new Quick_LinkedList();
            if (Arr[i].length == 0) {
                List2d[i].first = null;
                List2d[i].last = null;
            }
            else {
                List2d[i].first = new Quick_Node(Arr[i][0]);
                Quick_Node n = List2d[i].first;
                for (int m = 1; m < Arr[i].length; m++) {
                    List2d[i].add(Arr[i][m]);
                }
                List2d[i].last = n;
            }
        }
        return List2d;
    }

    public void sort() {
        if (this.first == null || this.first.next == null) {
            return;
        }
        Quick_LinkedList smaller = new Quick_LinkedList();
        Quick_LinkedList larger = new Quick_LinkedList();

        Quick_Node pivot = this.first;
        Quick_Node curr = pivot.next;
        pivot.next = null;
        this.last = pivot;

        while (curr != null) {
            Quick_Node nxt = curr.next;
            if (curr.value <= pivot.value) {
                smaller.add(curr);
            }
            else {
                larger.add(curr);
            }
            curr = nxt;
        }

        smaller.sort();
        larger.sort();

        this.append(larger);
        this.prepend(smaller);
    }
}