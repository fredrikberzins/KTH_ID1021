import java.util.Random;

public class Queue_Inital {
    public static Integer[] unsorted(int n) {
		Random rnd = new Random();	
		Integer[] array = new Integer[n];
		for (int i = 0; i < n ; i++) {
			array[i] = rnd.nextInt(n*10);
		}	
		return array;
    }

    public static Integer[][] arr2d(int loop, int size) {
        Integer[][] arr = new Integer[loop][size] ;
		for (int i = 0; i < loop; i++) {
            arr[i] = unsorted(size);
        }
        return arr;
    }
}