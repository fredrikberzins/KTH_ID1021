public class Iterator {
    public boolean hasNext(Tree_Node n) {
        if (n.left != null || n.right != null) {
            return true;
        }
        return false;
    }
    
    public void next(Tree_Node n) {
        if (n.left != null) {
            next(n.left);
        }
        if (n.right != null) {
            next(n.right);
        }
        // to do for each
    }
    
}