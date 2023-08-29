package HP35;

public class Stack {
    public enum StackType {
        NUM,
        EMPTY
    }
    private StackType type;
    private int num = 0;
    
    static void Push(int pos, Item args) {
        stack[pos].Num(args);
    }
    
    static int Pop() {
        int value = stack[pos].num;
        stack[pos].type = StackType.EMPTY;
        return value;
    }
}