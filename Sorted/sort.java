import java.util.Random;

public class Sort {
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }   
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = (int)Math.floor((first+last)/2);
            System.out.println(index);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                first = index ;
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page?
                last = index ;
                continue;
            }
            // Why do we land here? What should we do?
            return false;
        }
    }

    public static void main(String[] args){
        int[] sort_array;
        sort_array = sorted(50);
        if (binary_search(sort_array, 30)){
            System.out.println("Yay");
        }
        else{
            System.out.println("Nay");
        }
    }
}
