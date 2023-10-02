public class Queue<T> {
    private class Node {
        public T value;
        public Node next;
    
        public Node(T val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public void add(T item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        }
        else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public T remove() {
        Node n = first;
        if (first == null) {
            return null;
        } else if (first.next == last) {
            last = null;
        } else {
            first = first.next;
        }
        return n.value;
    }
}