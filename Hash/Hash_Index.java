import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Index {
    Hash_IndexNode[] data;

    public class Hash_IndexNode {
        Integer zipCode;
        String name;
        Integer population;
    
        public Hash_IndexNode(Integer zipCode, String name, Integer population) {
            this.zipCode = zipCode;
            this.name = name;
            this.population = population;
        }
    }

    public Hash_Index(String file) {
        data = new Hash_IndexNode[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Hash_IndexNode(code, row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Hash_IndexNode lookup(Integer key) {
        if (data[key] == null) {
            return null;
        }
        return data[key];
    }
}