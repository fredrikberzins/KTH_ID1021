public class Hash_Hash {

    public static int hashInteger(Integer key, int mod) {
        return key % mod;
    }

    public int hashString(String key, int mod) {
        char[] chars = key.toCharArray();
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            value = (31 * value + chars[i]) % mod;
        }
        return value;
    }
}

