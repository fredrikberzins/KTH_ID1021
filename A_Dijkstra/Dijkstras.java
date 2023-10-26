import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {
    private Path[] done;
    private PriorityQueue<Path> queue;
    private Dijkstras_Map map;

    public class Path implements Comparable<Path>{
        private Dijkstras_City city;
        private Dijkstras_City previous;
        private Integer distance;

        public Path(Dijkstras_City city) {
            this.city = city;
            this.previous = null;
            this.distance = 0;
        }

        public Path(Dijkstras_City city, Dijkstras_City previous, Integer distance) {
            this.city = city;
            this.previous = previous;
            this.distance = distance;
        }

        @Override
        public int compareTo(Path path) {
            if (this.distance == path.distance) {
                return 0;
            } else if (this.distance > path.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public Dijkstras(Dijkstras_Map map) {
        done = new Path[Dijkstras_Map.size()];
        queue = new PriorityQueue<Path>();
    }

    public Integer distance(Dijkstras_City city) {
        if (city != null && done[city.id] != null) {
            return done[city.id].distance;
        } else {
            return null;
        }
    }

    public Integer cities() {
        Integer n = 0;
        for (int i = 0; i < done.length; i++) {
            if (done[i] != null) {
                n++;
            }
        }
        return n;
    }

    public Dijkstras_City from(Dijkstras_City city) {
        return done[city.id].previous;
    }

    public void search(Dijkstras_City from, Dijkstras_City destination) {
        Path ex = new Path(from);
        queue.add(ex);
        shortest(destination);
    }

    public void shortest(Dijkstras_City destination) {
        while (!queue.isEmpty()) {
            Path entr = queue.remove();
            Dijkstras_City city = entr.city;

            if (done[city.id] == null) {
                done[city.id] = entr;
                if (city == destination) {
                    break;
                }
                Integer sofar = entr.distance;
                for(Dijkstras_Connection conn : city.neighbors) {
                    Dijkstras_City to = conn.city;
                    if (done[to.id] == null) {
                        Path ex = new Path(to, city, sofar+conn.distance);
                        queue.add(ex);
                    }
                }
            }
        }
    }
}