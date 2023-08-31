public class Calculator {
    Item[] expression;
    int instructionPointer;
    Stack stack;

    public Calculator(Item[] expression) {
        this.expression = expression;
        this.instructionPointer = 0;
        this.stack = new Stack(Math.round(expression.length / 2) + 1);
    }

    public void step() {
        Item next = expression[instructionPointer++];
        switch(next.type()) {
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
                stack.push(next.value());
                break;
            }
        }
    }

    public int run() {
        while ( instructionPointer < expression.length ) {
            step();
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expression = {
        Item.Value(10),
        Item.Value(2),
        Item.Value(5),
        Item.Mul(),
        Item.Add()
        };
        Calculator calc = new Calculator(expression);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}  