import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Index {
    Node[] data;

    public class Node {
        Integer zipCode;
        String name;
        Integer population;
    
        public Node(Integer zipCode, String name, Integer population) {
            this.zipCode = zipCode;
            this.name = name;
            this.population = population;
        }
    }

    public Hash_Index(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found Index");
        }
    }

    public Node lookup(Integer key) {
        if (data[key] == null) {
            return null;
        }
        return data[key];
    }
}