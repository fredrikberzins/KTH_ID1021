import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class T9_tree {
    Node root;
    
    public class Node {
        public Node[] next;
        public boolean valid;
        public Node() {
            next = new Node[27];
            valid = false;
        }
        
        private void add(Node curr, char[] word, int wordIndx) {
            char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'å', 'ä', 'ö'};
            if (wordIndx >= word.length) {
                curr.valid = true;
                return;
            }
            char letter = word[wordIndx];
            
            int index = - 1;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == letter) {
                    index = i;
                    break;
                }
            }
            if (index == -1)
                return;
                
            if (curr.next[index] == null)
                curr.next[index] = new Node();

            add(curr.next[index], word, (wordIndx + 1));
        }
    }

    public T9_tree() {
        root = new Node();
    }

    public T9_tree(String file) {
        root = new Node();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            char[] word;
            while ((line = br.readLine()) != null) {
                word = line.toCharArray();
                root.add(root, word, 0);
            }
            br.close();
        } catch (Exception e) {
            System.out.print("\t file " + file + " not found");
        }
    }

    public void add(String line) {
        char[] word = line.toCharArray();
        root.add(root, word, 0);
    }

    public ArrayList<String> decode(String key) {
        Node n = root;
        char[] keys = key.toCharArray();
        int[] word = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            word[i] = (Integer.valueOf(keys[i])-48);
        }
        ArrayList<String> results = new ArrayList<String>();

        return lookup(n, word, 0, "", results);
    }

    private ArrayList<String> lookup(Node curr, int[] word, int wordIndx, String currWord, ArrayList<String> results) {
        if (wordIndx >= word.length) {
            searchBranch(curr, currWord, results);
            return results;
        }
        int index = ((word[wordIndx]-1)*3);
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "x", "y", "z", "å", "ä", "ö"};
        
        if (curr.next[index] != null)
            lookup(curr.next[index], word, (wordIndx + 1), currWord + letters[index], results);

        if (curr.next[index + 1] != null)
            lookup(curr.next[index + 1], word, (wordIndx + 1), currWord + letters[index + 1], results);

        if (curr.next[index + 2] != null)
            lookup(curr.next[index + 2], word, (wordIndx + 1), currWord + letters[index + 2], results);

        return results;

    }

    private void searchBranch(Node curr, String currWord, ArrayList<String> results) {
        if (curr.valid)
            results.add(currWord);
        
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "x", "y", "z", "å", "ä", "ö"};

        for (int i = 0; i < curr.next.length; i++) {
            Node next = curr.next[i];
            if (next != null) {
                searchBranch(next, currWord + letters[i], results);
            }
        }
    }
}