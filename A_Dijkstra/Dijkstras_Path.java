public class Dijkstras_Path {
    private Dijkstras_City city;
    private Dijkstras_City previus;
    private Integer distance;
    private Integer index;

    public Dijkstras_Path() {
        
    }

    public static Integer dijkstrasSearch(Dijkstras_City from, Dijkstras_City to) {
        if (from == to) {
            return 0;
        }
        dijkstrasSearch(null, from, to, 0);
    }

    public static Integer dijkstrasSearch(Dijkstras_City prev, Dijkstras_City curr, Dijkstras_City dest, Integer dist) {
        if (curr == prev) {
            return 0;
        }

        Integer shortest = null;
        for (Dijkstras_Connection conn : curr.neighbors) {
            Integer distToNext = dijkstrasSearch(curr, conn.city, dest, dist);
            if (distToNext != null) {
                if ((shortest == null) || shortest > (distToNext + conn.distance)) {
                    shortest = distToNext + conn.distance;
                }
            }
        }
    }
}