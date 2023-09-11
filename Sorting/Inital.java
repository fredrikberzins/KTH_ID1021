import java.util.Random;

public class Inital {
    public static int[] unsorted(int n) {
		Random rnd = new Random();	
		int[] array = new int[n];
        int modifyer = rnd.nextInt(3) + 1;
		for (int i = 0; i < n ; i++) {
			array[i] = rnd.nextInt(n) * modifyer;
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
}