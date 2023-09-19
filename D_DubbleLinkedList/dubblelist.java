public class DubbleList {
    private class Node {
        public int value;
        public Node prev;
        public Node next;
    
        public Node(int val) {
            this.value = val;
            prev = null;
            next = null;
        }
    }

    private Node first;

    public DubbleList(int length) {
        first = new Node(0);
        Node n = first;
        for (int i = 1; i < length; i++)
        {
            n.next = new Node(i);
            n.next.prev = n;
            n = n.next;
        }
    }

    public void add(int item) {
        Node n = new Node(item);
        first.prev = n;
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

    public void append(DubbleList b) {
        Node n = first;
        while (n.next != null) {
            n = n.next;
        }
        n.next = b.first;
        n.next.prev = n;
    }
}