import java.util.Random;

public class Sorting_Inital {
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

    public static int[] copyArr(int[] Arr) {
        int[] tempArr = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            tempArr[i] = Arr[i];
        }
        return tempArr;
    }

    public static int[][] copyArr2d(int[][] Arr2d) {
        int[][] tempArr = new int[Arr2d.length][Arr2d[0].length];
        for (int i = 0; i < Arr2d.length; i++) {
            for (int n = 0; n < Arr2d[i].length; n++) {
                tempArr[i][n] = Arr2d[i][n];
            }
        }
        return tempArr;
    }

    public static void swap(int[] array, int i, int n) {
        int temp = array[i];
        array[i] = array[n];
        array[n] = temp;
    }
    
    public static void printArr(int[] Arr) {    
        System.out.println("");
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i] + ", ");
        }
        System.out.println();
    }
    public static void printArr2d(int[][] Arr2d) {    
        System.out.println("");
        for (int i = 0; i < Arr2d.length; i++) {
            System.out.print("Next: ");
            for (int n = 0; n < Arr2d[i].length; n++) {
                System.out.print(Arr2d[i][n] + ", ");
            }
        }
        System.out.println();
    }
}