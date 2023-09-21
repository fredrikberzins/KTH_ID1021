import java.util.Random;

public class DoubleList {

    public static DoubleNode Dfirst;

    public DoubleList(int length) {
        Dfirst = new DoubleNode();
        DoubleNode n = Dfirst;
        for (int i = 1; i < length; i++)
        {
            n.next = new DoubleNode();
            n.next.prev = n;
            n = n.next;
        }
    }

    public int length() {
        int length = 0;
        for (DoubleNode n = Dfirst; n != null; n = n.next) {
            length++;
        }
        return length;
    }

    public static DoubleNode[][] DNodeArray2d(DoubleList[] lists, int fixedSize) {
        DoubleNode[][] returnlist = new DoubleNode[lists.length][fixedSize];
		Random rnd = new Random();
        for(int j = 0; j < lists.length; j++) {
            for(int i = 0; i < fixedSize; i++) {	
                DoubleNode n = Dfirst;
                int temp = rnd.nextInt(lists[j].length());
                for(int m = 0; m < temp ; m++) {
                    n = n.next;
                }
                returnlist[j][i] = n;
            }
        }
        return returnlist;
    }

    public void link(DoubleNode m) {
        Dfirst.prev = m;
        m.next = Dfirst;
        Dfirst = m;
    }

    public void unlink(DoubleNode m) {
        DoubleNode n = Dfirst;
        if (m == n) {
            Dfirst = m.next;
            m.next.prev = null;
        }
        else if (m.next != null) {
            m.prev.next = m.next;
            m.next.prev = m.prev;
        }
        else{
            m.prev.next = null;
        }
    }
}