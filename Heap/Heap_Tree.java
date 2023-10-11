public class Heap_Tree {
    private Heap_TreeNode root = null;

    public boolean empty() {
        return root == null;
    }

    public void enqueue(int value) {
        if (root == null) {
            root = new Heap_TreeNode(value);
        } else {
            root.add(value);
        }
    }

    public Heap_TreeNode dequeue() {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            Heap_TreeNode temp = root;
            root = null;
            return temp;
        } else {
            return root.remove();
        }
    }

    public int Push(int i){
        if(root == null)
            return 0;
        root.value +=i;
        int depth = 0;
        return root.push(root, depth);
    }

    public int height(Heap_TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
 
    public int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public void printTree(int[][] M, Heap_TreeNode root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.value;
        printTree(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }
 
    public void TreePrinter() {
        int h = height(this.root);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("     ");
                else
                    System.out.print(M[i][j] +"  ");
            }
            System.out.println();
        }
    }
}