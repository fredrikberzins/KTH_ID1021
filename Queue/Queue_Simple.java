public class Queue_Simple<T> {
    
    private class Node {
        public T item;
        public Node next;
    
        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first;

    public Queue_Simple() {
        first = null;
    }

    public void add(T item) {
        if (first == null) {
            first = new Node(item);
        } else {
            Node n = first;
            while(n.next != null) {
                n = n.next;
            }
            n.next = new Node(item);
        }
    }

    public T remove() {
        Node n = first;
        if (n == null) {
            return null;
        }
        first = n.next;
        return n.item;
    }
}