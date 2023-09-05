private static int[] sorted(int n) {
    Random rnd = new Random();
    int[] array = new int[n];
    int nxt = 0;
    for (int i = 0; i < n ; i++) {
        nxt += rnd.nextInt(10) + 1;
        array[i] = nxt;
    }
    return array;
}