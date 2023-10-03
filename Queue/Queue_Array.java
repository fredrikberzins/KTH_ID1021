public class Queue_Array<T> {
    private int first;
    private int firstEmpty;
    private Object[] arr;

    public Queue_Array() {
        arr = new Object[2];
        first = 0;
        firstEmpty = 0;
    }

    public Queue_Array(int size) {
        arr = new Object[size];
        first = 0;
        firstEmpty = 0;
    }

    private boolean empty() {
        return first == firstEmpty;
    }

    private void expArr() {
        Object[] temp = new Object[(arr.length*2)];
        int t = 0;
        for (int a = first; a < firstEmpty; t++, a++) {
            temp[t] = arr[a%arr.length];
        }
        arr = temp;
        first = 0;
        firstEmpty = t++;
    }

    public void add (T val) {
        if (first%arr.length == firstEmpty%arr.length != this.empty()) {
            expArr();
        }
        arr[firstEmpty%arr.length] = val;
        firstEmpty++;
    }

    public T remove() {
        if (this.empty()) {
            return null;
        }
        T val = (T)arr[first%arr.length];
        first++;
        return val;
    }
}
