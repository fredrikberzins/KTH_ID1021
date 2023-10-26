import java.util.ArrayList;

public class Dijkstras_City {
    public String name;
    public Integer id;
    public ArrayList<Dijkstras_Connection> neighbors;

    public Dijkstras_City(String name) {
        this.name = name;
        this.neighbors = new ArrayList();
    }

    public void connect(Dijkstras_City neighbor, Integer distance) {
        neighbors.add(new Dijkstras_Connection(neighbor, distance));
    }

    public String getName() {
        return this.name;
    }
}