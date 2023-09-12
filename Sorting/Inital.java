import java.util.Random;

public class Inital {
    public static int[] unsorted(int n) {
		Random rnd = new Random();	
		int[] array = new int[n];
		for (int i = 0; i < n ; i++) {
			array[i] = rnd.nextInt(n*10);
		}	
		return array;
    }
    public static int[][] array2d(int loop, int n) {
        int[][] array = new int[loop][n];
		for (int i = 0; i < loop; i++) {
            array[i] = unsorted(n);
        }
        return array;
    }

    public static void swap(int[] array, int i, int n) {
        int temp = array[i];
        array[i] = array[n];
        array[n] = temp;
    }

}