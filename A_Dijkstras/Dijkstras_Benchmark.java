public class Dijkstras_Benchmark {
    public static void main(String[] arg) {
        Dijkstras_Map map = new Dijkstras_Map("A_Dijkstras/europe.csv");
        String[][] route = {
            {"Malmö", "Göteborg"},
            {"Göteborg", "Stockholm"},
            {"Malmö", "Stockholm"},
            {"Stockholm", "Sundsvall"},
            {"Stockholm", "Umeå"}
        };
        
        System.out.println(map.size());

		System.out.printf("those: # sort through an array of length n, time in ms\n");
		System.out.printf("%25s|%25s|%25s|%25s|%25s|\n", "Malmö-Göte", "Göte-Sthm", "Malmö-Sthm", "Sthm-Sunds", "Sthm-Umeå");
        System.gc();

        for (int i = 0; i < route.length; i++) {
            long t0 = System.nanoTime();
            Dijkstras dijkstras = new Dijkstras(map);
            dijkstras.search(map.lookup(route[i][0]), map.lookup(route[i][1]));
            double t = (System.nanoTime() - t0);
            System.out.printf("%25.3f|", (t/1000));
            System.gc();
        }
    }
}