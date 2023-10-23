public class Graph {

    private static Integer shortestNaive(Graph_City from, Graph_City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shortest = null;
        for (Graph_Connection conn : from.neighbors) {
            Integer distance = shortestNaive(conn.city, to, max - conn.distance);
            if (distance != null) {
                if ((shortest == null) || shortest > distance +conn.distance) {
                    shortest = distance + conn.distance;
                }
            }
        }
        return shortest;
    }

    private static Integer shortestMovingMax(Graph_City from, Graph_City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shortest = null;
        for (Graph_Connection conn : from.neighbors) {
            Integer distance = shortestMovingMax(conn.city, to, max - conn.distance);
            if (distance != null) {
                if ((shortest == null) || shortest > distance +conn.distance) {
                    shortest = distance + conn.distance;
                    max = shortest;
                }
            }
        }
        return shortest;
    }

    public void main(String[] arg) {
        Graph_Map map = new Graph_Map("trains.csv");
        Integer[] max = {500,500,500,500,500,500,500,500,500};
        Integer[] distance = new Integer[9];
		System.out.printf("those: # sort through an array of length n, time in ns\n");
		System.out.printf("%15s%15s%15s%15s%15s%15s%15s%15s%15s\n", "Mal-Göt", "Göt-Sthm", "Mal-Sthm", "Sthm-Sund", "Sthm-Umeå", "Göt-Sund", "Sund-Umeå", "Umeå-Göt", "Göt-Umeå");
        System.gc();
        
        long t0 = System.nanoTime();
        distance[0] = shortestNaive(map.lookup("Malmö"), map.lookup("Göteborg"), max[0]);
        double t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        distance[1] = shortestNaive(map.lookup("Göteborg"), map.lookup("Stockholm"), max[1]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        distance[2] = shortestNaive(map.lookup("Malmö"), map.lookup("Stockholm"), max[2]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        distance[3] = shortestNaive(map.lookup("Stockholm"), map.lookup("Sundsvall"), max[3]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));
    
        t0 = System.nanoTime();
        distance[4] = shortestNaive(map.lookup("Stockholm"), map.lookup("Umeå"), max[4]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        distance[5] = shortestNaive(map.lookup("Göteborg"), map.lookup("Sundsvall"), max[5]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));
        
        t0 = System.nanoTime();
        distance[6] = shortestNaive(map.lookup("Sundsvall"), map.lookup("Umeå"), max[6]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f" , (t));

        t0 = System.nanoTime();
        distance[7] = shortestNaive(map.lookup("Umeå"), map.lookup("Göteborg"), max[7]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f\n" , (t));
        
        t0 = System.nanoTime();
        distance[8] = shortestNaive(map.lookup("Göteborg"), map.lookup("Umeå"), max[8]);
        t = (System.nanoTime() - t0)/1000;
        System.out.printf("%15.0f\n" , (t));

        for(Integer dis : distance) {
            System.out.printf("%15.0f\n" , (dis));
        }
    }
}