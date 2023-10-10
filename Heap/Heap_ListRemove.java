public class Heap_ListRemove {
    private Heap_ListNode first;

    public Heap_ListRemove() {
        this.first = null;
    }

    public Boolean empty() {
        return first == null;
    }

    public void add(Integer value) {
        Heap_ListNode n = first;
        if (first == null) {
            first = new Heap_ListNode(value);
        } else if (first.value > value) {
            first = new Heap_ListNode(value, first);
        } else {
            while (n.next != null && n.next.value < value) {
                n = n.next;
            }
            n.next = new Heap_ListNode(value, n.next);
        }
    }

    public Heap_ListNode remove() {
        Heap_ListNode n = first;
        first = n.next;
        return n;
    }
}