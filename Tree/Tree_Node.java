import java.util.Random;

public class Tree_Node {
    public Integer key;
    public Integer value;
    public Tree_Node left, right;
    public Tree_Node(Integer key, Integer value) {
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

    private static void loop(Tree_Node n) {
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
    
    public static int[][] key2dArray(BinaryTree[] B, int fixedSize) {
        Random rnd = new Random();
        int[][] keyArr = new int[B.length][fixedSize];
        int key;
        for (int i = 0; i < B.length; i ++) {
            Tree_Node n = B[i].root;
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