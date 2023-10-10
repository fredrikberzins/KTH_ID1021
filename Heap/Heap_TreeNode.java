class Heap_TreeNode {
        public Integer prio;
        private Heap_TreeNode left, right;

        public Heap_TreeNode(Integer prio){
            this.prio = prio;
            this.size = 0;
            this.left = null;
            this.right = null;
        }

        public void add(Integer prio) {
            if (prio < this.prio) {
                Integer temp = this.prio;
                this.prio = prio;
                prio = temp;
            }
            if (right != null) {
                Heap_TreeNode temp = left;
                right.add(prio);
                left = right;
                right = temp;
            }
            else {
                right = new Heap_TreeNode(prio);
            }
        }

        public Heap_TreeNode remove() {
            if (right == null) {
                return left;
            }
            else {
                if (left == null) {
                    return right;
                }
                else {
                    if (left.prio < right.prio) {
                        prio = left.prio;
                        left = left.remove();
                    } else {
                        prio = right.prio;
                        right = right.remove();
                    }
                    return this;
                }
            }
        }
    }