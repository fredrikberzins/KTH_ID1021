import java.util.Random;

public class Quick_Inital {

    public static int[][] Unsorted2d(int amount, int length) {
        Random rnd = new Random();
        int[][] R = new int[amount][length];
		for (int i = 1; i < amount; i++) {
			for (int m = 1; m < length; m++) {
                R[i][m] = rnd.nextInt(length*10);
            }
		}
        return R;
    }

    public static void QuickSortArr(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = arr[hi];
            int curr = lo - 1;

            for (int j = lo; j < hi; j++) {
                if (arr[j] <= pivot) {
                    curr++;
                    swap(arr, curr, j);
                }
            }

            swap(arr, curr + 1, hi);
            int pivotIndx = curr + 1;
            QuickSortArr(arr, lo, (pivotIndx-1));
            QuickSortArr(arr, pivotIndx, hi);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}