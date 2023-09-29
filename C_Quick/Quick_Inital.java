import java.util.Random;

public class Quick_Inital {
    public int[] Unsorted(int amount, int length) {
        Random rnd = new Random();
        int[] R = new int[length];
		for (int i = 1; i < amount; i++) {
			for (int m = 1; m < length; m++) {
                R[i][m] = rnd.nextInt(length*2);
            }
		}
        return R;
    }

    public Quick_Sort() {

    }
}