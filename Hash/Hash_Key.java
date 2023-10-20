import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Key {
    Node[] data;
    Integer[] keys;
    int mod = 8123;
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
        keys = new Integer[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i++] = code;
                int index = Hash_Hash.hashInteger(code, mod);
                if (data[index] == null) {
                    data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
                }
                else {
                    Node curr = data[index];
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    curr = new Node(code, row[1], Integer.valueOf(row[2]));
                }
            }
            max = i - 1;
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found Key");
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
        int index = Hash_Hash.hashInteger(key, this.mod);
        Node current = this.data[index];
        while (current != null) {
            if (current.zipCode.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}