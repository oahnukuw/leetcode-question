package leetcode.editor.cn;

import java.util.function.BinaryOperator;

public class P307RangeSumQueryMutable {

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        SegementTree st;

        public NumArray(int[] nums) {
            st = new SegementTree(0, nums.length - 1, Integer::sum, 0);
            for (int i = 0; i < nums.length; i++) {
                st.update(st.root, i, nums[i]);
            }
        }

        public void update(int index, int val) {
            st.update(st.root, index, val);

        }

        public int sumRange(int left, int right) {
            return st.query(st.root, left, right);

        }
    }

    class SegementNode {
        int l, r;
        int mergeVal;
        SegementNode left, right;

        public SegementNode(int l, int r, int mergeVal) {
            this.l = l;
            this.r = r;
            this.mergeVal = mergeVal;
        }
    }

    class SegementTree {
        SegementNode root;
        BinaryOperator<Integer> merger;
        int defaultValue;

        public SegementTree(int[] nums, BinaryOperator<Integer> merger) {
            this.merger = merger;
            this.root = build(nums, 0, nums.length - 1);
        }

        public SegementTree(int begin, int end, BinaryOperator<Integer> merger, int defaultValue) {
            this.merger = merger;
            this.defaultValue = defaultValue;
            this.root = new SegementNode(begin, end, defaultValue);
        }

        public SegementNode build(int[] nums, int l, int r) {
            if (l == r) {
                return new SegementNode(l, r, nums[l]);
            }
            int mid = l + (r - l) / 2;
            SegementNode left = build(nums, l, mid);
            SegementNode right = build(nums, mid + 1, r);
            SegementNode node = new SegementNode(l, r, merger.apply(left.mergeVal, right.mergeVal));
            node.left = left;
            node.right = right;
            return node;
        }

        // Construct the children of node if it doesn't have the children.
        public void initChildrenNeeded(SegementNode node) {
            if (node.l == node.r) {
                return;
            }
            int mid = node.l + (node.r - node.l) / 2;
            if (node.left == null) {
                node.left = new SegementNode(node.l, mid, defaultValue);
            }
            if (node.right == null) {
                node.right = new SegementNode(mid + 1, node.r, defaultValue);
            }
        }

        // Update leaf value
        public void update(SegementNode node, int index, int val) {
            if (node.l == node.r) {
                node.mergeVal = val;
                return;
            }
            initChildrenNeeded(node);
            int mid = node.l + (node.r - node.l) / 2;
            if (index <= mid) {
                update(node.left, index, val);
            }
            if (index > mid) {
                update(node.right, index, val);
            }
            node.mergeVal = merger.apply(node.left.mergeVal, node.right.mergeVal);
        }

        public int query(SegementNode node, int qL, int qR) {
            if (qL > qR) {
                return -1;
            }
            // System.out.println("qLR" + qL + " " + qR);
            // System.out.println(node.l + " " + node.r);
            if (node.l == qL && node.r == qR) {
                return node.mergeVal;
            }
            int mid = node.l + (node.r - node.l) / 2;
            if (qR <= mid) {
                return query(node.left, qL, qR);
            } else if (qL > mid) {
                return query(node.right, qL, qR);
            } else {
                return merger.apply(
                        query(node.left, qL, mid),
                        query(node.right, mid + 1, qR));
            }
        }
    }


    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
    // leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        // put your test code here

    }
}
