public class Heap_Node {
    public int value;
    public Heap_Node next;

    public Heap_Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Heap_Node(int value, Heap_Node next) {
        this.value = value;
        this.next = next;
    }
}