public class Heap_Array {
    private Integer[] arr;
    private int firstEmpty;

    public Heap_Array() {
        arr = new Integer[2];
    }

    public boolean empty() {
        return arr[0] == null;
    }

    private void swap(int indx1, int indx2) {
        Integer temp = this.arr[indx1];
        this.arr[indx1] = this.arr[indx2];
        this.arr[indx2] = temp;
        System.out.println("swaped");
    }

    private void expArr() {
        Integer[] temp = new Integer[(arr.length*2)];
        for (int a = 0; a < arr.length; a++) {
            temp[a] = arr[a];
        }
        arr = temp;
    }

    public void add(int value) {
        if (firstEmpty == arr.length) {
            expArr();
        }
        if (arr[0] == null) {
            arr[0] = value;
            firstEmpty = 1;
            return;
        }
        arr[firstEmpty] = value;
        int indx1 = firstEmpty;
        int indx2 = (indx1-1)/2;
        System.out.println("index 1: " + indx1 + " value 1: " + arr[indx1]);
        System.out.println("index 2: " + indx2 + " value 2: " + arr[indx2]);
        while (arr[indx1] < arr[indx2]) {
            swap(indx1, indx2);
            indx1 = indx2;
            indx2 = (indx1-1)/2;
        }
        
        System.out.println("looking for magic");
        for (int i = (int)firstEmpty; i < arr.length; i++) {
            if (arr[i] == null) {
                firstEmpty = i;
                break;
            }
        }
        System.out.println("found magic: " + firstEmpty);
    }

    public Integer remove() {
        if (arr[0] == null) {
            return null;
        }
        Integer temp = arr[0];
        return null;
    }
}