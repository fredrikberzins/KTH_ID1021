public class Graph_Paths {
    Graph_City[] path;
    int stackPointer;

    public Graph_Paths() {
        path = new Graph_City[52];
        stackPointer = 0;
    }

    public Integer shortest(Graph_City from, Graph_City to) {
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
            Integer distance = shortest(conn.city, to);
            if (distance != null) {
                if ((shortest == null) || shortest > distance +conn.distance) {
                    shortest = distance + conn.distance;
                }
            }
        }
        path[stackPointer--] = null;
        return shortest;
    }

}
