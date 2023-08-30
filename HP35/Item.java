public class Item {
    private ItemType type;
    private int value = 0;

    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }
    public static Item Add(){
        Item NewItem = new Item();
        NewItem.type = ItemType.ADD;
        return NewItem;
    }
    public static Item Sub(){
        Item NewItem = new Item();
        NewItem.type = ItemType.SUB;
        return NewItem;
    }
    public  static Item Mul(){
        Item NewItem = new Item();
        NewItem.type = ItemType.MUL;
        return NewItem;
    }
    public  static Item Div(){
        Item NewItem = new Item();
        NewItem.type = ItemType.DIV;
        return NewItem;
    }
    public  static Item Value(int args){
        Item NewItem = new Item();
        NewItem.type = ItemType.VALUE;
        NewItem.value = args;
        return NewItem;
    }

    public int value(){
        return value;
    }
    public ItemType type(){
        return type;
    }
} 