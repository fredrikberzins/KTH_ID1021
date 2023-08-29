package HP35;

import HP35.Item.ItemType;

public class Calculator {
    Item[] expression;
    int ip;
    Stack stack;
    public Calculator(Item[] expression) {
        this.expression = expression;
        this.ip = 0;
        this.stack = new Stack();
    }

    public void step() {
        Item nxt = expression[ip++];
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

    public int run() {
        while ( ip < expression.length ) {
            step();
        }
        return stack.Pop();
    }
}

public static void main() {
    // 10 + 2 * 5
    // 10 2 5 * + in reversed Polish notation
    Item[] expression = {
        Item.Value(10),
        Item.Value(2),
        Item.Value(5),
        Item.Mul(),
        Item.Add()
    };
    int StackMaxSize = 0;
    for(int i = 0; i < expression.length; i++){
        if(expression.type == ItemType.VALUE){
          StackMaxSize++;  
        };
    }
    Calculator calc = new Calculator(expression);
    int result = calc.run();
    System.out.println(" Calculator: res = " + result);
}