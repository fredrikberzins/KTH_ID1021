public class LinkedList {

    public LinkedList(int n) {
        Node last = null;
        for (int i = 0; i < n; i++) {
            last = new Node(i);
            last.next = last;
        }
        first = last;
    }

    Node first;

    private class Node {
        public int value;
        public Node next;
    
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public void add(int item) {
        Node n = new Node(item);
        n.next = first;
        first = n;
    }

    public int length() {
        int length = 0;
        for (Node n = first; n == null; n = n.next) {
            length++;
        }
        return length;
    }
    
    public boolean find(int value) {
        Node n = first;
        while (n != null) {
            if (n.value == value) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public void remove(int value) {
        Node n = first;
        if (n.value == value) {
            first = n.next;
        }
        while (n.next != null) {
            if (n.next.value == value) {
                n = n.next.next;
            }
            n = n.next;
        }
    }

    public void append(LinkedList b) {
        Node n = first;
        while (n.next != null) {
            n = n.next;
        }
        n.next = b.first;
    }
}