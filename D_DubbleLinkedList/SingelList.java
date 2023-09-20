import java.util.Random;

public class SingelList {

    public static SingelNode Sfirst;

    public SingelList(int length) {
        Sfirst = new SingelNode();
        SingelNode n = Sfirst;
		for (int i = 1; i < length; i++)
		{
			n.next = new SingelNode();
			n = n.next;
		}
    }

    public int length() {
        int length = 0;
        for (SingelNode n = Sfirst; n != null; n = n.next) {
            length++;
        }
        return length;
    }

    public static SingelNode[][] SNodeArray2d(SingelList[] lists, int fixedSize) {
        SingelNode[][] returnlist = new SingelNode[lists.length][fixedSize];
		Random rnd = new Random();	
        for(int j = 0; j < lists.length; j++) {
            for(int i = 0; i < fixedSize; i++) {
                SingelNode n = Sfirst;
                int temp = rnd.nextInt(lists[j].length());
                for(int m = 0; m < temp ; m++) {
                    n = n.next;
                }
                returnlist[j][i] = n;
            }
        }
        return returnlist;
    }

    public void link(SingelNode m) {
        m.next = Sfirst;
        Sfirst = m;
    }

    public void unlink(SingelNode m) {
        SingelNode n = Sfirst;
        if (m == Sfirst) {
            Sfirst = m.next;
        }
        else {
            boolean loop = true;
            while (loop && n != null) {
                if (n.next == m) {
                    n = m.next;
                    loop = false;
                }
                else {
                    n = n.next;
                }
            }
        }
    }
}