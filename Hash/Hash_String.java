import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_String {
    Node[] data;
    int max = 0;

    public class Node {
        String zipCode;
        String name;
        Integer population;
    
        public Node(String zipCode, String name, Integer population) {
            this.zipCode = zipCode;
            this.name = name;
            this.population = population;
        }
    }

    public Hash_String(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found String");
        }
    }
    
    public Node linear(String zipCode) {
        for (int i = 0; i < data.length; i++) {
            if (zipCode.equals(data[i].zipCode)) {
                return data[i];
            }
        }
        return null;
    }

    public Node binary(String zipCode){
        int first = 0;
        int last = this.max;
        while(true) {
            int index = (first+last)/2;

            int compare = zipCode.compareTo(data[index].zipCode);
            if( compare == 0) {
                return data[index];
            } else if (compare > 0 && index < last) {
                first = index + 1;
                continue;
            } else if (compare < 0 && index > first) {
                last = index - 1;
                continue;
            }
            if (2 >= (last - first)) {
                return null;
            }
        }
    }
}