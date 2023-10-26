import java.io.BufferedReader;
import java.io.FileReader;

public class Dijkstra_Map {
    private Dijkstra_City[] cities;
    private final int mod = 1667;

    public Dijkstra_Map(String file) {
        cities = new Dijkstra_City[mod];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Dijkstra_City one = lookup(row[0]);
                Dijkstra_City two = lookup(row[1]);
                Integer distance = Integer.valueOf(row[2]);
                one.connect(two, distance);
                two.connect(one, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public Dijkstra_City lookup(String name) {
        int indx = hash(name);
        while (true) {
            if (cities[indx] == null) {
                Dijkstra_City city = new Dijkstra_City(name);
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