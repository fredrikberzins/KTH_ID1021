import java.util.Random;

public class Heap_inital {
    public static Integer[] Unsorted2d(int length) {
        Random rnd = new Random();
        Integer[] R = new Integer[length];
        for (int m = 0; m < length; m++) {
            R[m] = rnd.nextInt(length*10);
        }
        return R;
    }
}