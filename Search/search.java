public class search {
    public static boolean linear(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }   
        return false;
    }
    public static boolean betterLinear(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] < key) {
                continue;
            }
            else if (array[index] == key) {
                return true;
            }
            return false;
        }
        return false;
    } 
    public static boolean binary(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = (int)Math.round((first+last)/2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                first = index+1;
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page?
                last = index-1;
                continue;
            }
            // Why do we land here? What should we do?
            if (2 >= (last - first)) {
                return false;
            }
        }
    }
}
