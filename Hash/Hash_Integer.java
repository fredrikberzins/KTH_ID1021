import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Integer {
    Hash_IntegerNode[] data;
    int max = 0;
    
    public class Hash_IntegerNode {
        Integer zipCode;
        String name;
        Integer population;

        public Hash_IntegerNode(Integer zipCode, String name, Integer population) {
            this.zipCode = zipCode;
            this.name = name;
            this.population = population;
            max++;
        }
    }

    public Hash_Integer(String file) {
        data = new Hash_IntegerNode[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Hash_IntegerNode(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public Hash_IntegerNode linear(Integer zipCode) {
        int i = 0;
        while(data[i] != null) {
            if (zipCode == data[i].zipCode) {
                return data[i];
            }
            i++;
        }
        return null;
    }

    public Hash_IntegerNode binary(Integer zipCode){
        int first = 0;
        int last = this.max;
        while (true) {
            int index = (int)Math.round((first+last)/2);
            if (data[index].zipCode == zipCode) {
                return data[index];
            }
            if (data[index].zipCode < zipCode && index < last) {
                first = index+1;
                continue;
            }
            if (data[index].zipCode > zipCode && index > first) {
                last = index-1;
                continue;
            }
            if (2 >= (last - first)) {
                return null;
            }
        }
    }
}