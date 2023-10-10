public class Heap_Array {
    private Heap_ArrayNode[] arr;
    private int firstEmpty;
    private int size;

    public Heap_Array() {
        this.arr = new Heap_ArrayNode[7];
        this.firstEmpty = 0;
        this.size = 0;
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
            arr[0].value = value;
            firstEmpty = 1;
            return;
        }
        arr[firstEmpty].value = value;
        int indx1 = firstEmpty;
        int indx2 = (indx1-1)/2;
        //--System.out.println("index 1: " + indx1 + " value 1: " + arr[indx1]);
        //--System.out.println("index 2: " + indx2 + " value 2: " + arr[indx2]);
        while (arr[indx1].value < arr[indx2].value) {
            swap(indx1, indx2);
            //--System.out.println("swaped");
            indx1 = indx2;
            indx2 = (indx1-1)/2;
        }
        
        //--System.out.println("looking for magic");
        for (int i = firstEmpty; i < arr.length; i++) {
            if (arr[i] == null) {
                firstEmpty = i;
                break;
            }
        }
        //--System.out.println("found magic: " + firstEmpty);
    }

    public Heap_ArrayNode remove() {
        if (arr[0] == null) {
            return null;
        }
        Heap_ArrayNode temp = arr[0];
        arr[0] = null;
        int curr = 0;

        while (curr*2+2 <= size) {
            if (arr[curr*2+1] == null && arr[curr*2+2] == null) {
                return null;
            } else if (arr[curr*2+1] == null) {
                if (arr[curr].value > arr[curr*2+2].value) {
                    temp = arr[]
                }
            } else if (arr[curr*2+2] == null) {
                if (arr[curr].value > arr[curr*2+1].value) {

                }
            } else {

            }
        }

        return temp;
    }
}