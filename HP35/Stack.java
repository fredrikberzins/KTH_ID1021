public class Stack {

	// the root StackItem in the StackItem-sequence
	private int[] stackarray;
    private int top;


    // create the sequence
    Stack(int args) {
		stackarray = new int[args]; // stack array
		top = -1; //-1 to get first value at 0
	}

	public void push(int value) {
		top++;
		stackarray[top] = value;
	}

	public int pop() {
		int returnvalue = stackarray[top];
		stackarray[top] = 0;
		top--;
		return returnvalue;
	}
}