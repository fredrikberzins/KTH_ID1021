import java.util.Random;

public class Ini {
    public static SingelList[] SArray(int loop, int n) {
        SingelList[] returnnlist = new SingelList[loop];
        for(int i = 0; i < loop; i++) {
            returnnlist[i] = new SingelList(n);
        }
        return returnnlist;

    }
    public static DubbleList[] DArray(int loop, int n) {
        DubbleList[] returnnlist = new DubbleList[loop];
        for(int i = 0; i < loop; i++) {
            returnnlist[i] = new DubbleList(n);
        }
        return returnnlist;

    }
}
