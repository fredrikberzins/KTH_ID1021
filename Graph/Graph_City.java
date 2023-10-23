import java.util.ArrayList;

public class Graph_City {
    public String name;
    public ArrayList<Graph_Connection> neighbors;

    public Graph_City(String name) {
        this.name = name;
        this.neighbors = new ArrayList();
    }

    public void connect(Graph_City to, Integer distance) {

    }

    public String getName() {
        return this.name;
    }
}