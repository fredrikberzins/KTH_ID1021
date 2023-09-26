import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public static BinaryTree BinaryTreeLen(int length) {
	    Random rnd = new Random();
        BinaryTree R = new BinaryTree();
        for (int i = 0; i < length; i++) {
            Integer key = rnd.nextInt(length*10);
            Integer value = -key;
            R.add(key, value);
        }
        return R;
    }

    public void add(Integer key, Integer value) {
        root = add(root, key, value); 
    }
    
    private TreeNode add(TreeNode n, Integer key, Integer value) {
        if (n == null) {
            return new TreeNode(key, value);
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
        TreeNode n = lookup(root, key); 
        if (n == null) {
            return null;
        }
        return n.value;
    }
    
    private TreeNode lookup(TreeNode n, Integer key) {
        TreeNode R = null;
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
    public class TreeIterator implements Iterator<Integer> {
        private Stack<TreeNode> s;

        public TreeIterator(TreeNode n) {
            s = new Stack<TreeNode>();
            while (n != null) {
                s.push(n);
                n = n.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !s.isEmpty();
        }
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode c = s.pop();
            if (c.right != null) {
                while (c.right != null) {
                    s.push(c.right);
                    c.right = c.right.left;
                }
            }
            return c.value;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}