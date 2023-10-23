public class Graph_Search {
    public static Integer shortestNaive(Graph_City from, Graph_City to, Integer max) {
        if (max < 0) {
            return null;
        }

        if (from == to) {
            return 0;
        }   

        Integer shortest = null;
        for (Graph_Connection conn : from.neighbors) {
            Integer dist = shortestNaive(conn.city, to, (max - conn.distance));
            if (dist != null) {
                if ((shortest == null) || (shortest > (dist + conn.distance))) {
                    shortest = dist + conn.distance;
                }
            }
        }
        return shortest;
    }

    public static Integer shortestChangingMax(Graph_City from, Graph_City to, Integer max) {
        if (max < 0) {
            return null;
        }

        if (from == to) {
            return 0;
        }
        Integer shortest = null;
        for (Graph_Connection conn : from.neighbors) {
            Integer dist = shortestChangingMax(conn.city, to, max - conn.distance);
            if (dist != null) {
                if ((shortest == null) || (shortest > (dist + conn.distance))) {
                    shortest = dist + conn.distance;
                    max = shortest;
                }
            }
        }
        return shortest;
    }
}
