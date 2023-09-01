public class Stack_Static {

	private int[] stackarray;
    private int top;

    Stack_Static(int args) {
		stackarray = new int[args]; // stack array
		top = -1; //-1 to get first value at 0
	}

	public void push(int value) {
		top++;
		stackarray[top] = value;
	}

	public int pop() {
		int returnvalue = stackarray[top];
		top--;
        return returnvalue;
	}
}