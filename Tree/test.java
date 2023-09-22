public class test {
    public static void main(String[] args) {
        BinaryTree B = new BinaryTree();
        B.add(1, 101);
        B.add(2, 102);
        B.add(3, 103);
        B.add(4, 104);
        B.add(5, 105);
        B.root.print();
        System.out.println(B.lookup(5));
        System.out.println(B.lookup(4));
        System.out.println(B.lookup(3));
        System.out.println(B.lookup(2));
        System.out.println(B.lookup(1));
    }
}
