package HP35;

public class Calculator {
    Item[] expretion;
    int ip;
    Stack stack;
    public Calculator(Item[] expretion) {
        this.expretion = expretion;
        this.ip = 0;
        this.stack = new Stack();
    }
}

public static int[] Stack(Item[] args) {
    int stack_size = 0;
    for (int i = 0; i < args.length; i++) {
        if(args[i].type == ItemType.VALUE){  
            stack_size++;
        };
    }
    int[] stack = new int[stack_size];
    return stack;
}

public static void main() {
    // 10 + 2 * 5
    // 10 2 5 * + in reversed Polish notation
    Item[] expretion = {
        Item.Value(10),
        Item.Value(2),
        Item.Value(5),
        Item.Mul(),
        Item.Add()
    };
    int[] stack = Create_Stack(expretion);
    Calculator calc = new Calculator(expretion);
    int result = calc.run();
    System.out.println(" Calculator: res = " + result);
}

public int run() {
    while ( ip < expretion.length ) {
        step();
    }
    return stack.pop();
}

public void step() {
    Item nxt = expretion[ip++];
    switch(nxt.type()) {
        case ADD : {
            int y = stack.pop();
            int x = stack.pop();
            stack.push(x + y);
            break;
        }
        case SUB : {
            int y = stack.pop();
            int x = stack.pop();
            stack.push(x - y);
            break;
        }
        case MUL : {
            int y = stack.pop();
            int x = stack.pop();
            stack.push(x * y);
            break;
        }
        case DIV : {
            int y = stack.pop();
            int x = stack.pop();
            stack.push(x / y);
            break;
        }
        case VALUE : {
            stack.push(nxt.num);
            break;
        }
    }
}