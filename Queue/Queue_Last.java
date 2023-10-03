public class Queue_Last<T> {
    
    private class Node {
        public T item;
        public Node next;
    
        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    public Queue_Last() {
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
        return n.item;
    }
}