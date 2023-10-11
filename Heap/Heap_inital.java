import java.util.Random;

public class Heap_inital {
    public static int[] Unsorted(int length) {
        Random rnd = new Random();
        int[] R = new int[length];
        for (int m = 0; m < length; m++) {
            R[m] = rnd.nextInt(length*10);
        }
        return R;
    }
}