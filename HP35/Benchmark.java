public class Benchmark {
    int instructionPointer;

    private static void Bench_Static(int loop,int ops, Stack_Static stack) {
        System.out.println("Static Benchmark --------------------------");
        for(int n = 0; n < loop; n++) {
            System.gc();
            long befor_time = System.nanoTime();
            for(int i = 0; i < 1024; i++) {
                stack.push(0);
            }
            for(int i = 1023; 0 <= i; i--) {
                stack.pop();
            }
            long after_time = System.nanoTime();
            System.out.println(after_time-befor_time + ", ");
        }
        System.out.println("Static Benchmark Done ---------------------");
    }
    private static void Bench_Semi_Dynamic(int loop,int ops, Stack_Semi_Dynamic stack) {
        System.out.println("Semi Dynamic Benchmark --------------------------");
        for(int n = 0; n < loop; n++) {
            System.gc();
            long befor_time = System.nanoTime();
            for(int i = 0; i < 1024; i++) {
                stack.push(0);
            }
            for(int i = 1023; 0 <= i; i--) {
                stack.pop();
            }
            long after_time = System.nanoTime();
            System.out.println(after_time-befor_time + ", ");
        }
        System.out.println("Semi Dynamic Benchmark Done ---------------------");
    }
    private static void Bench_Dynamic(int loop,int ops, Stack_Dynamic stack) {
        System.out.println("Dynamic Benchmark --------------------------");
        for(int n = 0; n < loop; n++) {
            System.gc();
            long befor_time = System.nanoTime();
            for(int i = 0; i < 1024; i++) {
                stack.push(0);
            }
            for(int i = 1023; 0 <= i; i--) {
                stack.pop();
            }
            long after_time = System.nanoTime();
            System.out.println(after_time-befor_time + ", ");
        }
        System.out.println("Dynamic Benchmark Done ---------------------");
    }
    public static void main(String[] args){
        int loops = 100;
        int operations = 1024;
        Stack_Static stack_static = new Stack_Static(operations); // Static
        Stack_Semi_Dynamic stack_semi_dynamic = new Stack_Semi_Dynamic(); // semi Dynamic
        Stack_Dynamic stack_dynamic = new Stack_Dynamic(); // Dynamic
        Bench_Static(loops, operations, stack_static);
        Bench_Semi_Dynamic(loops, operations, stack_semi_dynamic);
        Bench_Dynamic(loops, operations, stack_dynamic);
    }
}
