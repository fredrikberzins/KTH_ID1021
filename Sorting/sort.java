public class sort {
    public static void selection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int curr = i;
            for (int n = i+1; n < array.length ; n++) {
                if (array[n] < array[curr]) {
                    curr = n;
                }
            }
            Inital.swap(array, i, curr);
        }
        return;
    }
    public static void insert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int n = i; 0 < n; n--) {
                if (array[n] < array[n - 1] ) {
                    Inital.swap(array, n, n - 1);
                }
            }
        }
        return;
    }
    public static void merge(int[] array) {
        if (array.length == 0)
            return;
        int[] aux = new int[array.length];
        sort_merge(array, aux, 0, array.length -1);
        return;
    }
    private static void sort_merge(int[] array, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi)/2;
            // sort the items from lo to mid
            sort_merge(array, aux, lo, mid);
            // sort the items from mid+1 to hi
            sort_merge(array, aux, mid + 1, hi);
            // merge the two sections using the additional array
            merge_merge(array, aux, lo, mid, hi);
        }
    }
    private static void merge_merge(int[] array, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from array to aux
        for (int i = lo; i < hi; i++) {
            aux[i] = array[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indices from lo to hi
            for ( int k = lo; k < hi; k++) {
                // if i is greater than mid then
                // move the j'th item to the array, update j
                if (mid < i) {
                    array[k] = aux[j];
                    j++;
                }
                // else if j is greater than hi then
                // move the i'th item to the array, update i
                else if (hi < j) {
                    array[k] = aux[i];
                    i++;
                }
                // else if the i'th item is smaller than the j¨ath item,
                // move the i'th item to the array, update i
                else if (aux[i] < aux[j]) {
                    array[k] = aux[i];
                    i++;
                }
                // else
                // move the j'th item to the array, update j
                else {
                    array[k] = aux[j];
                    j++;
                }
            }
        }
        
}
