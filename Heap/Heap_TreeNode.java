class Heap_TreeNode {
        public int value;
        public int size;
        public Heap_TreeNode left, right;

        public Heap_TreeNode(int value){
            this.value = value;
            this.size = 1;
            this.left = null;
            this.right = null;
        }

        public void add(int value) {
            size++;
            if (value < this.value) {
                int temp = this.value;
                this.value = value;
                value = temp;
            }
            if(left == null){
                left = new Heap_TreeNode(value);
                return;
            }
            if(right == null){
                right = new Heap_TreeNode(value);
                return;
            }
            if(left.size<right.size){
                left.add(value);
            }else{
                right.add(value);
            }
        }

        public Heap_TreeNode remove() {
            if (right == null && left == null) {
                return null;
            } else if (right == null) {
                this.value = left.value;
                left = left.remove();
            } else if (left == null) {
                this.value = right.value;
                right = right.remove();
            } else {
                if (left.value <= right.value) {
                    this.value = left.value;
                    left = left.remove();
                } else {
                    this.value = right.value;
                    right = right.remove();
                }
            }
            return this;
        }

        public int push(Heap_TreeNode node, int depth) {
        if (left == null && right == null) {
            return depth;
        }
    
        Heap_TreeNode smaller = left;
    
        if (right != null && right.value < left.value) {
            smaller = right;
        }
    
        if (node.value <= smaller.value) {
            return depth;
        } else {
            int tempPrio = node.value;
            node.value = smaller.value;
            smaller.value = tempPrio;
            return smaller.push(smaller, depth + 1);
        }
    } 
}