import java.util.ArrayList;

public class Dijkstras_City {
    public Integer id;
    public String name;
    public ArrayList<Dijkstras_Connection> neighbors;

    public Dijkstras_City(String name, Integer id) {
        this.id = id;
        this.name = name;
        this.neighbors = new ArrayList<Dijkstras_Connection>();
    }

    public void connect(Dijkstras_City neighbor, Integer distance) {
        neighbors.add(new Dijkstras_Connection(neighbor, distance));
    }

    public String getName() {
        return this.name;
    }
}