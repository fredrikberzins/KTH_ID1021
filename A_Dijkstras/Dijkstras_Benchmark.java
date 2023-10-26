import java.util.ArrayList;

public class Dijkstras_Benchmark {
    public static void main(String[] arg) {
        Dijkstras_Map map = new Dijkstras_Map("A_Dijkstras/europe.csv");
        String[][] route = {
            {"Malmö", "Göteborg"},
            {"Göteborg", "Stockholm"},
            {"Umeå", "Göteborg"},
            {"Göteborg", "Umeå"},
            {"Berlin", "Stockholm"},
            {"Berlin", "Seinäjoki"},
            {"Berlin", "Bukarest"},
            {"Berlin", "Valencia"},
            {"Berlin", "Manchester"},
            {"Berlin", "Bari"},
            {"Berlin", "Berlin"},
            {"Berlin", "Rom"},
            {"Berlin", "Paris"},
            {"Berlin", "London"},
            {"Berlin", "Gdansk"},
            {"Berlin", "Prag"}
        };

		System.out.printf("those: # sort through an array of length n, time in ms\n");
        System.gc();
        for (int n = 0; n < 10; n++) {
            for (int i = 0; i < route.length; i++) {
                Dijkstras dijkstras = new Dijkstras(map);
                dijkstras.search(map.lookup(route[i][0]), map.lookup(route[i][1]));
                System.gc();
            }
        }
        for (int i = 0; i < route.length; i++) {
            long t0 = System.nanoTime();
            Dijkstras dijkstras = new Dijkstras(map);
            dijkstras.search(map.lookup(route[i][0]), map.lookup(route[i][1]));
            double t = (System.nanoTime() - t0);
            ArrayList<Dijkstras_City> path = Dijkstras.getPath(map.lookup(route[i][0]), map.lookup(route[i][1]));
            int n = 0;
            for (Dijkstras.Path paths : dijkstras.done){
                if (paths != null) {
                    n++;
                }
            }
            
            int distance = 0;
            for (int k = path.size(); k > 0; k--) {
                distance = Dijkstras.distance(path.get(k-1));
            }
            System.out.printf("%11s-%11s|%6.2f|%5d|%5d|  ",route[i][0], route[i][1], (t/1000), (n), (distance));
            for (int k = path.size(); k > 0; k--) {
                System.out.print(path.get(k-1).getName() + ", ");
            }
            System.out.println();
            System.gc();
        }
    }
}