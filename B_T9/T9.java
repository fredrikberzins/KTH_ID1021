import java.util.ArrayList;

public class T9 {
    public static void main(String[] arg) {
        T9_tree tree = new T9_tree("B_T9/kelly.txt");
        String[] keyCombos = {"15261", "74735", "2861", "7967", "1951", "3961", "151453", "65131429"};

        for (String key : keyCombos) {
            ArrayList<String> result = tree.decode(key);
            System.out.println("\n" + key + ": ");
            for (int i = 0; i < result.size(); i++) {
                System.out.println("\t" + result.get(i));
            }
        }
    }
}