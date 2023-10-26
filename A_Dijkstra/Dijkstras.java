public class Dijkstras {
    public static void main(String[] arg) {
        Dijkstras_Map map = new Dijkstras_Map("A_Dijksta/europe.csv");
        String[][] route = {
        };
        Integer[] distance = new Integer[9];

		System.out.printf("those: # sort through an array of length n, time in ms\n");
		System.out.printf("%25s|%25s|%25s|%25s|%25s|%25s|%25s|%25s|%25s|\n", "Malmö-Göte", "Göte-Sthm", "Malmö-Sthm", "Sthm-Sunds", "Sthm-Umeå", "Göte-Sunds", "Sunds-Umeå", "Umeå-Göte", "Göte-Umeå");
        System.gc();

        for (int i = 0; i < route.length; i++) {
            long t0 = System.nanoTime();
            distance[i] = Dijkstras_Path.dijkstrasSearch();
            double t = (System.nanoTime() - t0);
            System.out.printf("%25.3f|", (t/1_000_000));
            System.gc();
        }
        System.out.println();
        for(Integer dis : distance) {
            if (dis == null) {
                System.out.printf("%25s|", "null");
            } else {
                System.out.printf("%25d|", dis);
            } 
        }
        System.out.println();
    }
}