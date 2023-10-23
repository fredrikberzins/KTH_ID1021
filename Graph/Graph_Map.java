import java.io.BufferedReader;
import java.io.FileReader;

public class Graph_Map {
    private Graph_City[] cities;
    private final int mod = 541;
    private int size;

    public Graph_Map(String file) {
        cities = new Graph_City[mod];
        size = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Graph_City one = lookup(row[0]);
                Graph_City two = lookup(row[1]);
                Integer distance = Integer.valueOf(row[2]);
                one.connect(two, distance);
                two.connect(one, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        return Math.floorMod(name.hashCode(), mod);
    }

    private Integer size() {
        return this.size;
    }

    public Graph_City lookup(String name) {
        int indx = hash(name);
        while (true) {
            if (cities[indx] == null) {
                size++;
                Graph_City city = new Graph_City(name);
                cities[indx] = city;
                return city;
            }
            if (cities[indx].name.equals(name)) {
                return cities[indx];
            }
            indx = (indx + 1) % mod;
        }
    }
}