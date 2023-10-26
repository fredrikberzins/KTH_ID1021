import java.util.ArrayList;

public class Dijkstra_City {
    public String name;
    public Integer id;
    public ArrayList<Dijkstra_Connection> neighbors;

    public Dijkstra_City(String name) {
        this.name = name;
        this.neighbors = new ArrayList();
    }

    public void connect(Dijkstra_City neighbor, Integer distance) {
        neighbors.add(new Dijkstra_Connection(neighbor, distance));
    }

    public String getName() {
        return this.name;
    }
}