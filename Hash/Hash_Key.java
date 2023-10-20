import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Key {
    Node[] data;
    Integer[] keys;
    int mod = 1300;
    int max = 0;

    public class Node {
        Integer zipCode;
        String name;
        Integer population;
        Node next;

    
        public Node(Integer zipCode, String name, Integer population) {
            this.zipCode = zipCode;
            this.name = name;
            this.population = population;
            this.next = null;
        }
    }

    public Hash_Key(String file) {
        data = new Node[mod];
        keys = new Integer[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                if (data[Hash_Hash.hashInteger(code, mod)] == null) {
                    data[Hash_Hash.hashInteger(code, mod)] = new Node(code, row[1], Integer.valueOf(row[2]));
                    i++;
                } else {
                    Node curr = data[Hash_Hash.hashInteger(code, mod)];
                    while (curr != null) {
                        curr = curr.next;
                    }
                    curr = new Node(code, row[1], Integer.valueOf(row[2]));
                }
            }
            max = i;
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found Key");
        }
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            if (keys[i] == null) {
                break;
            }
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
        int index = Hash_Hash.hashInteger(key, mod);
        Node current = data[index];
        while (current != null) {
            if (current.zipCode.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null; // Key not found.
    }
}