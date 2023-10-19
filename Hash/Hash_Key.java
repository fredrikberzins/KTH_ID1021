import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Key {
    Node[] data;
    Integer[] keys;
    int mod = 10000;
    int max = 0;

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

    public Hash_Key(String file) {
        data = new Node[100000];
        keys = new Integer[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[Hash_Hash.hashInteger(code, mod)] = code;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public Node lookup(Integer key) {
        if (data[key] == null) {
            return null;
        }
        return data[key];
    }

}