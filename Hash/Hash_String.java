import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_String {
    Hash_StringNode[] data;
    int max = 0;

    public Hash_String(String file) {
        data = new Hash_StringNode[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Hash_StringNode(row[0], row[1], Integer.valueOf(row[2]));
                max++;
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public Hash_StringNode linear(String zipCode) {
        int i = 0;
        while(data[i] != null) {
            if (zipCode == data[i].zipCode) {
                return data[i];
            }
            i++;
        }
        return null;
    }
    public Hash_StringNode binary(String zipCode){
        Integer zip = Integer.valueOf(zipCode.replaceAll("\\s",""));
        int first = 0;
        int last = this.max/2;
        while (true) {
            int index = (int)Math.round((first+last)/2);
            Integer zipValue = Integer.valueOf(data[index].zipCode.replaceAll("\\s",""));
            if (zipCode.equals(data[index].zipCode)) {
                return data[index];
            }
            if (zipValue < zip && index < last) {
                first = index+1;
                continue;
            }
            if (zipValue > zip && index > first) {
                last = index-1;
                continue;
            }
            if (2 >= (last - first)) {
                return null;
            }
        }
    }
}