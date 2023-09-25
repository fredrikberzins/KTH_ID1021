import java.util.Random;

public class BinaryTree {

    Tree_Node root;

    public BinaryTree() {
        root = null;
    }

    public static BinaryTree BinaryTreeLen(int length) {
	    Random rnd = new Random();
        BinaryTree R = new BinaryTree();
        for (int i = 0; i < length; i++) {
            Integer key = rnd.nextInt(length*2);
            Integer value = -key;
            R.add(key, value);
        }
        return R;
    }

    public void add(Integer key, Integer value) {
        root = add(root, key, value); 
    }
    
    private Tree_Node add(Tree_Node n, Integer key, Integer value) {
        if (n == null) {
            return new Tree_Node(key, value);
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
        Tree_Node n = lookup(root, key); 
        if (n == null) {
            return null;
        }
        return n.value;
    }
    
    private Tree_Node lookup(Tree_Node n, Integer key) {
        Tree_Node R = null;
        if (n.key == key) {
            R = n;
        } else if (n.key > key) {
            R = lookup(n.left, key);
        } else if (n.key < key) {
            R = lookup(n.right, key);
        }
        return R;
    }
    public static BinaryTree[] BinaryTree2dArray(int loop, int n) {
        BinaryTree[] R = new BinaryTree[loop];
        for (int i = 0; i < loop; i++) {
            R[i] = BinaryTreeLen(n);
        }
        return R;
    }
}

