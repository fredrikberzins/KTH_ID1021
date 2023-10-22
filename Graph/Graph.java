import java.io.BufferedReader;
import java.io.FileReader;

public class Graph {

        private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public class Map {
        private City[] cities;
        private final int mod = 541;
        public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
            //--
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
        }
        //--
    }

    //--

    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    public static void main(String[] arg) {
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s\n", "Mal-Göt", "Göt-Sthm", "Mal-Sthm", "Sthm-Sund", "Sthm-Umeå", "Göt-Sund", "Sund-Umeå", "Umeå-Göt", "Göt-Umeå");
        System.gc();
        
        long t0 = System.nanoTime();
        shortest();
        double t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));
    
        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f\n" , (t));
        
        t0 = System.nanoTime();
        shortest();
        t = (System.nanoTime() - t0);
        System.out.printf("%15.0f\n" , (t));
    }
}