public class Heap_Array {
    private Heap_ArrayNode[] arr;
    private int firstEmpty;

    public Heap_Array() {
        this.arr = new Heap_ArrayNode[3];
        this.firstEmpty = 0;
    }

    public boolean empty() {
        return arr[0] == null;
    }

    private void swap(int indx1, int indx2) {
        Heap_ArrayNode temp = this.arr[indx1];
        this.arr[indx1] = this.arr[indx2];
        this.arr[indx2] = temp;
    }

    private void expArr() {
        Heap_ArrayNode[] temp = new Heap_ArrayNode[(arr.length*2)];
        for (int a = 0; a < arr.length; a++) {
            temp[a] = arr[a];
        }
        arr = temp;
    }

    public void add(int value) {
        if (firstEmpty == (arr.length-1)) {
            this.expArr();
        }
        if (arr[0] == null) {
            arr[0] = new Heap_ArrayNode(value);
            firstEmpty = 1;
            return;
        }
        arr[firstEmpty] = new Heap_ArrayNode(value);
        int indx1 = firstEmpty;
        int indx2 = (indx1-1)/2;
        while (arr[indx1].value < arr[indx2].value) {
            swap(indx1, indx2);
            indx1 = indx2;
            indx2 = (indx1-1)/2;
        }
        for (int i = firstEmpty; i < arr.length; i++) {
            if (arr[i] == null) {
                firstEmpty = i;
                break;
            }
        }
    }

    public Heap_ArrayNode remove() {
        if (arr[0] == null) {
            return null;
        }
        Heap_ArrayNode temp = arr[0];
        arr[0] = null;
        int index = 0;

        while (index*2+2 < arr.length) {
            if (arr[index*2+1] == null && arr[index*2+2] == null) {
                break;
            } else if (arr[index*2+2] == null) {
                swap(index, index*2+1);
                index = index*2+1;
            } else if (arr[index*2+1] == null) {
                swap(index, index*2+2);
                index = index*2+2;
            } else {
                if (arr[index*2+1].value <= arr[index*2+2].value) {
                    swap(index, index*2+1);
                    index = index*2+1;
                } else {
                    swap(index, index*2+2);
                    index = index*2+2;
                }
            }
        }
        return temp;
    }
}