public class Graph {
    public static void main(String[] arg) {
        Graph_Map map = new Graph_Map("Graph/trains.csv");
        String[][] route = {
            {"Malmö", "Göteborg"},
            {"Göteborg", "Stockholm"},
            {"Malmö", "Stockholm"},
            {"Stockholm", "Sundsvall"},
            {"Stockholm", "Umeå"},
            {"Göteborg", "Sundsvall"},
            {"Sundsvall", "Umeå"},
            {"Umeå", "Göteborg"},
            {"Göteborg", "Umeå"}
        };
        Integer[] max = {180,240,300,360,540,540,240,720,720};
        Integer[] distance = new Integer[9];

		System.out.printf("those: # sort through an array of length n, time in ms\n");
		System.out.printf("%25s|%25s|%25s|%25s|%25s|%25s|%25s|%25s|%25s|\n", "Malmö-Göte", "Göte-Sthm", "Malmö-Sthm", "Sthm-Sunds", "Sthm-Umeå", "Göte-Sunds", "Sunds-Umeå", "Umeå-Göte", "Göte-Umeå");
        System.gc();

        for (int i = 0; i < route.length; i++) {
            long t0 = System.nanoTime();
            distance[i] = Graph_Search.shortestNaive(map.lookup(route[i][0]), map.lookup(route[i][1]), max[i]);
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

        for (int i = 0; i < route.length; i++) {
            long t0 = System.nanoTime();
            distance[i] = Graph_Search.shortestChangingMax(map.lookup(route[i][0]), map.lookup(route[i][1]), max[i]);
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

        for (int i = 0; i < route.length; i++) {
            Graph_Paths paths = new Graph_Paths();
            long t0 = System.nanoTime();
            distance[i] = paths.shortest(map.lookup(route[i][0]), map.lookup(route[i][1]));
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

        for (int i = 0; i < route.length; i++) {
            Graph_Better better = new Graph_Better();
            long t0 = System.nanoTime();
            distance[i] = better.shortest(map.lookup(route[i][0]), map.lookup(route[i][1]), null);
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