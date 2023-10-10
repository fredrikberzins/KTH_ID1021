public class Heap_ListAdd {
    private Heap_ListNode first;

    public Heap_ListAdd() {
        this.first = null;
    }

    public Boolean empty() {
        return first == null;
    }

    public void add(Integer value) {
        first = new Heap_ListNode(value, first);
    }

    public Heap_ListNode remove() {
        Heap_ListNode n = first;
        if (first == null) {
            return null;
        } else if (first.next == null) {
            first = first.next;
            return n;
        }

        Heap_ListNode u = first;
        
        while (n.next != null) {
            if (n.next.value < u.value){
                u = n;
            }
            n = n.next;
        }
        Heap_ListNode temp = u.next;
        u.next = u.next.next;
        return temp;
    }
}