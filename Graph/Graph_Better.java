public class Graph_Better {
    static Graph_City[] path;
    static int stackPointer;

    public Graph_Better() {
        path = new Graph_City[1024];
        stackPointer = 0;
    }

    public Integer shortest(Graph_City from, Graph_City to, Integer max) {
        if ((max != null) && (max < 0)) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        for (int i = 0; i < stackPointer; i++) {
            if (path[i] == from) {
                return null;
            }
        }
        path[stackPointer++] = from;

        Integer shortest = null;
        for (Graph_Connection conn : from.neighbors) {
            Integer distance = shortest(conn.city, to, (max != null) ? max - conn.distance : null);
            if (distance != null) {
                if ((shortest == null) || shortest > (distance + conn.distance)) {
                    shortest = distance + conn.distance;
                    max = shortest;
                }
            }
        }
        path[stackPointer--] = null;
        return shortest;
    }
}