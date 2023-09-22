import java.util.Random;

public class DoubleLinkedList_inital {
    public static SingelList[] SArray(int loop, int n) {
        SingelList[] returnnlist = new SingelList[loop];
        for(int i = 0; i < loop; i++) {
            returnnlist[i] = new SingelList(n);
        }
        return returnnlist;

    }
    public static DoubleList[] DArray(int loop, int n) {
        DoubleList[] returnnlist = new DoubleList[loop];
        for(int i = 0; i < loop; i++) {
            returnnlist[i] = new DoubleList(n);
        }
        return returnnlist;

    }
}
