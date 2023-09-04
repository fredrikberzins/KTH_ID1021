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
        int index = ....... ;
            if (array[index] == key) {
            // hmm what now?
            :
        }
        if (array[index] < key && index < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
            first = ...... ;
            continue;
        }
        if (array[index] > key && index > first) {
            // The index position holds something that is larger than
            // what we're looking for, what is the last possible page?
            last = ...... ;
            continue;
        }
        // Why do we land here? What should we do?
        :
    }
}
