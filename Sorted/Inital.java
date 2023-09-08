import java.util.Random;

public class Inital {
    public static int[] sorted_dup(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int next = rnd.nextInt(n/2);

        for (int i = 0; i < n ; i++) {
            next += rnd.nextInt(n/2) + 1;
            array[i] = next;
        }
        return array;
    }
    public static int[] sorted_search(int n) {
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
    public static int[][] array2d(int loop, int n) {
        int[][] temp = new int[loop][n];
		for (int i = 0; i < loop; i++) {
            temp[i] = sorted_dup(n);
        }
        return temp;
    }
}