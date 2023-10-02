import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Queue_Tree {

    TreeNode root;

    public Queue_Tree() {
        root = null;
    }

    public static Queue_Tree TreeLen(int length) {
	    Random rnd = new Random();
        Queue_Tree R = new Queue_Tree();
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
    public static Queue_Tree[] Queue_Tree2dArray(int loop, int n) {
        Queue_Tree[] R = new Queue_Tree[loop];
        for (int i = 0; i < loop; i++) {
            R[i] = TreeLen(n);
        }
        return R;
    }

    public class TreeNode {
        public Integer key;
        public Integer value;
        public TreeNode left, right;
        public TreeNode(Integer key, Integer value) {
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

        private static void loop(TreeNode n) {
            Random rnd = new Random();
            int val = rnd.nextInt(2);
            if (val == 0 && n.left != null) {
                n = n.left;
                loop(n);
            } else if (val == 1 && n.right != null) {
                n = n.right;
                loop(n);

            }
        }
        
        public static int[][] key2dArray(Queue_Tree[] B, int fixedSize) {
            Random rnd = new Random();
            int[][] keyArr = new int[B.length][fixedSize];
            int key;
            for (int i = 0; i < B.length; i ++) {
                TreeNode n = B[i].root;
                for (int j = 0; j < fixedSize; j++) {
                    int val = rnd.nextInt(2);
                    if (val == 0 && n.left != null) {
                        n = n.left;
                        loop(n);
                    } else if (val == 1 && n.right != null) {
                        n = n.right;
                        loop(n);

                    }
                    key = n.key;
                    keyArr[i][j] = key;               
                }
            }
            return keyArr;
        }
    }
}