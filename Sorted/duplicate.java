public class duplicate {
    public static boolean linear(int[] array1, int[] array2) {
        for(int i = 0; i < array1.length; i++) {
            int key = array1[i];
            for(int n = 0; n < array2.length; n++) {
                if (key == array2[n]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean betterLinear(int[] array1, int[] array2) {
        for(int i = 0, n = 0; i < array1.length && n < array2.length;) {
            if (array1[i] > array2[n]) {
                n++;
                continue;
            }
            else if (array1[i] < array2[n]) {
                i++;
                continue;
            }
            else if (array1[i] == array2[n]) {
                //System.out.println("yay");
                return true;
            }
        }
        //System.out.println("no");
        return false;
    }
    public static boolean binary(int[] array1, int[] array2) {
        for(int i = 0; i < array1.length; i++) {
            if (search.binary(array2, array1[i])) {
                return true;
            }
        }
        return false;
    }
}
