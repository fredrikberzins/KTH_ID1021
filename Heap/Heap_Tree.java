public class Heap_Tree {
    private Heap_TreeNode root = null;

    private void enqueue(Integer prio) {
        if (root == null) {
            root = new Heap_TreeNode(prio);
        }
        else {
            root.add(prio);
        }
    }

    private Integer dequeue() {
        if (root == null) {
            return null;
        }
        Integer prio = root.prio;

        
    }
}