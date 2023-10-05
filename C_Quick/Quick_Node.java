public class Quick_Node {
    public int value;
    public Quick_Node next;

    public Quick_Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Quick_Node(int value, Quick_Node next) {
        this.value = value;
        this.next = next;
    }
}