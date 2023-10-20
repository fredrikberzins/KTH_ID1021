import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Integer {
    Node[] data;
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

    public Hash_Integer(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found Integer");
        }
    }

    public Node linear(Integer zipCode) {
        for (int i = 0; i < data.length; i++) {
            if (zipCode.equals(data[i].zipCode)) {
                return data[i];
            }
        }
        return null;
    }

    public Node binary(Integer zipCode){
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