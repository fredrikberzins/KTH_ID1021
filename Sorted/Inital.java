import java.util.Random;

public class Inital {
    public static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int next = rnd.nextInt(10);

        for (int i = 0; i < n ; i++) {
            next += rnd.nextInt(10) + 1;
            array[i] = next;
        }
        return array;
    }
    public static int[] keys(int loop, int n) {
		Random rnd = new Random();	
		int[] indx = new int[loop];
		for (int i = 0; i < loop ; i++) {
			indx[i] = rnd.nextInt(n*5);
		}	
		return indx;
    }
}