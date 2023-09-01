public class Calculator {
    Item[] expression;
    int instructionPointer;
    //Stack_Dynamic stack;
    Stack_Semi_Dynamic stack;
    //Stack_Static stack;

    public Calculator(Item[] expression) {
        this.expression = expression;
        this.instructionPointer = 0;
        //this.stack = new Stack_Dynamic(); // Dynamic
        this.stack = new Stack_Semi_Dynamic(); // semi Dynamic
        //this.stack = new Stack_Static((int)Math.round(expression.length / 2) + 1); // Static
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
        while (instructionPointer < expression.length) {
            step();
		}
        return stack.pop();
    }
    
    public static void main(String[] args) {
        // 1 + 2 * (3 + 4 * (5 + 6 * (7 + 8 * (9 + 10 * (11 + 12 * (13 + 14 * (15 + 16) ) ) ) ) ) )
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 + * + * + * + * + * + * + * + in reversed Polish notation
        Item[] expression = {
            Item.Value(1),
            Item.Value(2),
            Item.Value(3),
            Item.Value(4),
            Item.Value(5),
            Item.Value(6),
            Item.Value(7),
            Item.Value(8),
            Item.Value(9),
            Item.Value(10),
            Item.Value(11),
            Item.Value(12),
            Item.Value(13),
            Item.Value(14),
            Item.Value(15),
            Item.Value(16),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add(),
            Item.Mul(),
            Item.Add()
        };
        Calculator calc = new Calculator(expression);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}  