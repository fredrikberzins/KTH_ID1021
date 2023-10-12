import java.util.Random;

public class Heap_inital {
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
}