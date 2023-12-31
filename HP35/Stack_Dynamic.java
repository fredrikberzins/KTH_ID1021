public class Stack_Dynamic {

    private class StackItem {
        private StackItem above;
        private int value;
        private StackItem below;
    
        StackItem(int value) {
            this.value = value;
        }
    }
    
    private StackItem s;

    public void push(int value) {
        if (s == null) {
            s = new StackItem(value);
        }
        else {
            s.above = new StackItem(value);
            s.above.below = s;
            s = s.above;
        }
    }

    public int pop() {
        if (s == null) {
            System.out.println("No items on stack");
            System.exit(0);
            return 0;
        }
        else if (s.below == null) {
            StackItem sreturn = s;
            s = null;
            return sreturn.value;
        }
        else {
            s.below.above = null;
            StackItem sreturn = s;
            s = s.below;
            return sreturn.value;
        }
    }
}
