public class Queue {
    private class Node {
        public Integer value;
        public Node next;
    
        public Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    public Queue(int length) {
        first = new Node(0);
        Node n = first;
		for (int i = 1; i < length; i++)
		{
			n.next = new Node(i);
			n = n.next;
		}
        last = n;
    }

    public void add(Integer item) {
        Node n = new Node(item);
        n = last.next;
        last = n;
    }

    public Integer remove() {
        Node n = first;
        first = n.next;
    }
}