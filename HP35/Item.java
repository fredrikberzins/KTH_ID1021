package HP35;

public class Item {  
    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }
    private ItemType type;
    private int value = 0;
}