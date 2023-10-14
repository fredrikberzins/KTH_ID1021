import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Hash_inital {
    public static String[][] Unsorted2d(int amount, int length, String file) {
        int len = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) {
                len++;
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }

        String[] data = new String[len];
        String line;
        int j = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[j++] = row[0];
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
        
        Random rnd = new Random();
        String[][] R = new String[amount][length];
		for (int i = 0; i < amount; i++) {
			for (int m = 0; m < length; m++) {
                R[i][m] = data[rnd.nextInt(len)];
            }
		}
        return R;
    }

    public static Integer[][] Convert(String[][] string2d) {
        Integer[][] R = new Integer[string2d.length][string2d[0].length];
        for (int i = 0; i < string2d.length; i++) {
			for (int m = 0; m < string2d[i].length; m++) {
                R[i][m] = Integer.valueOf(string2d[i][m].replaceAll("\\s",""));
            }
		}
        return R;
    }
}