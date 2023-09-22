public class BinaryTree {
    public class Node {
        private Integer key;
        private Integer value;
        private Node left, right;
        private Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        root = add(root, key, value); 
    }
    
    private Node add(Node n, Integer key, Integer value) {
        if (n == null) {
            return new Node(key, value);
        } else if (n.key == key) {
            n.value = value;
        } else if (n.key > key) {
            n.left = add(n.left, key, value);
        } else if (n.key < key) {
            n.right = add(n.right, key, value);
        }
        return n;
    }

    public Integer lookup(Integer key) {
        Node n = lookup(root, key); 
        if (n == null) {
            return null;
        }
        return n.value;
    }
    
    private Node lookup(Node n, Integer key) {
        Node R = null;
        if (n.key == key) {
            R = n;
        } else if (n.key > key) {
            R = lookup(n.left, key);
        } else if (n.key < key) {
            R = lookup(n.right, key);
        }
        return R;
    }
}

