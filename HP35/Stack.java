/*public class Stack {

    public class StackItem {   
        private int value = 0;
        private StackItem next = null;
        public StackItem (int value)
		{
			this.value = value;
			next = null;
		}
    }
    private int topPossition = -1;
    private StackItem[] s = new StackItem[1];

    private StackItem root;

    public void Stacking() {
        root = new StackItem(0);
        StackItem n = root;
		n = n.next;
	}

    public void push(int args) {
		StackItem s = root;
		for (int i = 1; i < topPossition; i++) {
			s = s.next;
        }
        StackItem t = s.next;
		s.next = new StackItem(args);
		s.next.next = t;
        topPossition++;
	}

    public int pop() {
        StackItem s = root;
		for (int i = 0; i <= topPossition; i++){
			s = s.next;
        }
        
        int returnValue = s.value;
		s = s.next;
        topPossition--;
        return returnValue;
    }
    public int peek() {
        StackItem s = root;
		for (int i = 0; i <= topPossition; i++){
			s = s.next;
        }
        return s.value;
    }
}
*/
public class Stack {
	private class StackItem {
		public int value;
		public StackItem next;

		public StackItem (int value) {
			this.value = value;
			next = null;
		}
	}

	// the first StackItem in the StackItem-sequence
    private StackItem first;

    // create the sequence
    public Stack (int[] values) {
		if (values.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new StackItem(values[0]);
        StackItem n = first;
		for (int i = 1; i < values.length; i++) {
			n.next = new StackItem(values[i]);
			n = n.next;
		}
	}
    
	// length returns the StackItem length of this sequence
	public int length() {	
		int length = 0;
		for(StackItem n = first; n == null; n = n.next) {
			length++;
        }     
		return length;
	}

	public void push(int value) {
		StackItem n = first;
		while (n.next != null){
			n = n.next;
        }
		n.next = new StackItem(value);
	}
    public int pop() {
        StackItem n = first;
		for (int i = 0; i < length() ; i++) {
			n = n.next;
        }
        int returnvalue = n.value;
        //reset n fro 
		n = first;
		for (int i = 0; i <= length(); i++) {
			n = n.next;
        }
		n = n.next;
        return returnvalue;
	}
}