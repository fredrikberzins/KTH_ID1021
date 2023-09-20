import java.util.Random;

public class DubbleList {

    public static DubbleNode Dfirst;

    public DubbleList(int length) {
        Dfirst = new DubbleNode();
        DubbleNode n = Dfirst;
        for (int i = 1; i < length; i++)
        {
            n.next = new DubbleNode();
            n.next.prev = n;
            n = n.next;
        }
    }

    public int length() {
        int length = 0;
        for (DubbleNode n = Dfirst; n != null; n = n.next) {
            length++;
        }
        return length;
    }

    public static DubbleNode[][] DNodeArray2d(DubbleList[] lists, int fixedSize) {
        DubbleNode[][] returnlist = new DubbleNode[lists.length][fixedSize];
		Random rnd = new Random();
        for(int j = 0; j < lists.length; j++) {
            for(int i = 0; i < fixedSize; i++) {	
                DubbleNode n = Dfirst;
                int temp = rnd.nextInt(lists[j].length());
                for(int m = 0; m < temp ; m++) {
                    n = n.next;
                }
                returnlist[j][i] = n;
            }
        }
        return returnlist;
    }

    public void link(DubbleNode m) {
        Dfirst.prev = m;
        m.next = Dfirst;
        Dfirst = m;
    }

    public void unlink(DubbleNode n) {
        if (n == Dfirst) {
            Dfirst = n.next;
            n.next.prev = null;
        }
        if (n.next != null) {
            n.prev.next = null;
        }
        else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }
}