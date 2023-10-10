public class Heap_ListNode {
    public Integer value;
    public Heap_ListNode next;

    public Heap_ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public Heap_ListNode(Integer value, Heap_ListNode next) {
        this.value = value;
        this.next = next;
    }
}