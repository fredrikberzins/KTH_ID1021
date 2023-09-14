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
                    Inital.swap(array, n - 1 , n);
                }
                else{
                    break;
                }
            }
        }
        return;
    }
    public static void merge(int[] array) {
        if (array.length == 0){
            return;
        }
        int[] aux = new int[array.length];
        sort_merge(array, aux, 0, array.length -1);
        return;
    }

    private static void sort_merge(int[] array, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi)/2;
            sort_merge(array, aux, lo, mid);
            sort_merge(array, aux, mid + 1, hi);
            merge_merge(array, aux, lo, mid, hi);
        }
    }
    private static void merge_merge(int[] array, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }
        int i = lo;
        int j = mid+1;
        for ( int k = lo; k <= hi; k++) {
            if (j <= hi && i <= mid) {
                if (aux[i] <= aux[j]) {
                    array[k] = aux[i];
                    i++;
                } else {
                    array[k] = aux[j];
                    j++;
                }
            } else if (j <= hi) {
                array[k] = aux[j];
                j++;
            } else {
                array[k] = aux[i];
                i++;
            }
        }
    }

    public static void lowCopyMerge(int[] array) {
        if (array.length == 0){
            return;
        }
        int[] aux = Inital.copyArr(array);
        sort_lowCopyMerge(array, aux, 0, array.length -1);
        return;
    }

    private static void sort_lowCopyMerge(int[] array, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi)/2;
            sort_lowCopyMerge(aux, array, lo, mid);
            sort_lowCopyMerge(aux, array, mid + 1, hi);
            merge_lowCopyMerge(array, aux, lo, mid, hi);
        }
    }
    private static void merge_lowCopyMerge(int[] array, int[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for ( int k = lo; k <= hi; k++) {
            if (j <= hi && i <= mid) {
                if (aux[i] <= aux[j]) {
                    array[k] = aux[i];
                    i++;
                } else {
                    array[k] = aux[j];
                    j++;
                }
            } else if (j <= hi) {
                array[k] = aux[j];
                j++;
            } else {
                array[k] = aux[i];
                i++;
            }
        }
    }
        
}
