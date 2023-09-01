public class Stack_Semi_Dynamic {

	// the root StackItem in the StackItem-sequence
	public int[] stackarray;
    public int top;

    // create the sequence
    Stack_Semi_Dynamic() {
		stackarray = new int[1]; // stack array
		top = -1; //-1 to get first value at 0
	}

	private void resize(int newsize) {
		int[] newarray = new int[newsize];
		for (int i = 0; i <= top; i++) {
			newarray[i] = stackarray[i];
		}
		stackarray = newarray;
	}

	public void push(int value) {
		if (stackarray.length - 1 <= top) {
			resize(stackarray.length * 2);
		}
		top++;
		stackarray[top] = value;
	}

	public int pop() {
		if (top < stackarray.length/3) {
			resize((int)Math.round(stackarray.length / 2));
		}
		int returnvalue = stackarray[top];
		stackarray[top] = 0;
		top--;
        return returnvalue;
	}
}