import java.util.Random;

public class Quick_Inital {

    public static int[][] Unsorted2d(int amount, int length) {
        Random rnd = new Random();
        int[][] R = new int[amount][length];
		for (int i = 0; i < amount; i++) {
			for (int m = 0; m < length; m++) {
                R[i][m] = rnd.nextInt(length*10);
            }
		}
        return R;
    }

    public static void QuickSortArr(int[] arr, int loIndx, int hiIndx) {
        if (loIndx < hiIndx) {
            int pivotValue = arr[hiIndx];
            int pivot = loIndx - 1;

            for (int j = loIndx; j < hiIndx; j++) {
                if (arr[j] <= pivotValue) {
                    pivot++;
                    swap(arr, pivot, j);
                }
            }

            swap(arr, pivot + 1, hiIndx);
            QuickSortArr(arr, loIndx, pivot);
            QuickSortArr(arr, (pivot+1), hiIndx);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}