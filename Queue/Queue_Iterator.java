
    import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue_Iterator implements Iterator<Integer> {
    private Queue_TreeNode current;
    private Queue<Queue_TreeNode> queue;

    Queue_Iterator(Queue_TreeNode root) {
        queue = new Queue();
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();

        current = queue.remove();
        if (current.left != null)
            queue.add(current.left);
        if (current.right != null)
            queue.add(current.right);

        return current.value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}