public class Binary {
    public static boolean search(int[] array, int key) {
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
}