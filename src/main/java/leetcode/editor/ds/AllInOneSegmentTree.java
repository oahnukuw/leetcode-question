package leetcode.editor.ds;

class AllInOneSegmentTree {
    static class SegmentNode {
        int l, r;
        int mergeValue;
        SegmentNode left, right;

        // 累加懒标记,为 0 表示无懒更新
        int lazyAdd;

        // 赋值懒标记
        int lazyAssign;
        boolean hasLazyAssign;

        public SegmentNode(int l, int r, int mergeValue) {
            this.l = l;
            this.r = r;
            this.mergeValue = mergeValue;
            this.lazyAdd = 0;
            this.lazyAssign = 0;
            this.hasLazyAssign = false;
        }
    }

    private final SegmentNode root;
    private final int defaultValue;
    // "sum", "max" or "min"
    private final String type;

    public AllInOneSegmentTree(int start, int end, int defaultValue, String type) {
        if (type.equals("sum") || type.equals("max") || type.equals("min")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid type, must be sum, max, or min");
        }
        this.defaultValue = defaultValue;
        int rootMergeValue = computeRangeValue(start, end, defaultValue);
        this.root = new SegmentNode(start, end, rootMergeValue);
    }

    // 计算区间 [l, r] 赋值为 val 后的 mergeValue
    private int computeRangeValue(int l, int r, int val) {
        // 如果类型为求和，则返回区间长度乘以 val
        if (type.equals("sum")) {
            return (r - l + 1) * val;
        } else {
            // 如果类型为求最大值或最小值，则返回 val
            return val;
        }
    }

    // 根据区间长度更新 mergeValue，加上 delta
    private int applyAddToValue(SegmentNode node, int delta) {
        if (type.equals("sum")) {
            return node.mergeValue + (node.r - node.l + 1) * delta;
        } else {
            // 如果类型为求最大值或最小值，则返回当前值加上 delta
            return node.mergeValue + delta;
        }
    }

    // 根据类型合并左右子节点的值
    private int merge(int leftVal, int rightVal) {
        if (type.equals("sum")) {
            return leftVal + rightVal;
        } else if (type.equals("max")) {
            return Math.max(leftVal, rightVal);
        } else if (type.equals("min")) {
            return Math.min(leftVal, rightVal);
        }
        throw new IllegalArgumentException("Invalid type");
    }

    // 动态创建线段树节点
    private void initChildrenIfNeeded(SegmentNode node) {
        if (node.l == node.r) {
            return;
        }
        int mid = node.l + (node.r - node.l) / 2;
        if (node.left == null) {
            int leftMergeValue = computeRangeValue(node.l, mid, defaultValue);
            node.left = new SegmentNode(node.l, mid, leftMergeValue);
        }
        if (node.right == null) {
            int rightMergeValue = computeRangeValue(mid + 1, node.r, defaultValue);
            node.right = new SegmentNode(mid + 1, node.r, rightMergeValue);
        }
    }

    // 下传懒标记，保证子节点的数据正确
    private void pushDown(SegmentNode node) {
        // 如果存在赋值懒标记，优先下传赋值
        if (node.hasLazyAssign) {
            applyAssign(node.left, node.lazyAssign);
            applyAssign(node.right, node.lazyAssign);
            node.hasLazyAssign = false;
            node.lazyAssign = 0;
        }
        // 下传累加懒标记
        if (node.lazyAdd != 0) {
            applyAdd(node.left, node.lazyAdd);
            applyAdd(node.right, node.lazyAdd);
            node.lazyAdd = 0;
        }
    }

    // 将赋值懒标记下传到子节点
    private void applyAssign(SegmentNode child, int val) {
        child.hasLazyAssign = true;
        child.lazyAssign = val;
        // 清除累加懒标记
        child.lazyAdd = 0;
        child.mergeValue = computeRangeValue(child.l, child.r, val);
    }

    // 将累加懒标记下传到子节点
    private void applyAdd(SegmentNode child, int delta) {
        if (child.hasLazyAssign) {
            // 如果子节点已有赋值懒标记，则直接更新该赋值
            child.lazyAssign += delta;
            child.mergeValue = computeRangeValue(child.l, child.r, child.lazyAssign);
        } else {
            // 如果子节点没有赋值懒标记，则更新累加懒标记
            child.lazyAdd += delta;
            child.mergeValue = applyAddToValue(child, delta);
        }
    }

    // 单点赋值：将索引 index 赋值为 val
    public void update(int index, int val) {
        // 直接复用区间赋值方法
        rangeUpdate(index, index, val);
    }

    // 区间赋值：将闭区间 [qL, qR] 赋值为 val
    public void rangeUpdate(int qL, int qR, int val) {
        _rangeUpdate(root, qL, qR, val);
    }

    private void _rangeUpdate(SegmentNode node, int qL, int qR, int val) {
        if (node.r < qL || node.l > qR) {
            throw new IllegalArgumentException("Invalid update range");
        }
        // 当前节点完全包含于更新区间内
        if (qL <= node.l && node.r <= qR) {
            node.hasLazyAssign = true;
            node.lazyAssign = val;
            node.lazyAdd = 0;
            node.mergeValue = computeRangeValue(node.l, node.r, val);
            return;
        }

        initChildrenIfNeeded(node);
        pushDown(node);

        int mid = node.l + (node.r - node.l) / 2;
        if (qR <= mid) {
            _rangeUpdate(node.left, qL, qR, val);
        } else if (qL > mid) {
            _rangeUpdate(node.right, qL, qR, val);
        } else {
            _rangeUpdate(node.left, qL, mid, val);
            _rangeUpdate(node.right, mid + 1, qR, val);
        }
        node.mergeValue = merge(node.left.mergeValue, node.right.mergeValue);
    }

    // 单点累加：将索引 index 增加 delta（可为负数）
    public void add(int index, int delta) {
        // 直接复用区间累加方法
        rangeAdd(index, index, delta);
    }

    // 区间累加：将闭区间 [qL, qR] 增加 delta（可为负数）
    public void rangeAdd(int qL, int qR, int delta) {
        _rangeAdd(root, qL, qR, delta);
    }

    private void _rangeAdd(SegmentNode node, int qL, int qR, int delta) {
        if (node.r < qL || node.l > qR) {
            throw new IllegalArgumentException("Invalid update range");
        }
        if (qL <= node.l && node.r <= qR) {
            if (node.hasLazyAssign) {
                // 若已有赋值懒标记，则更新赋值值
                node.lazyAssign += delta;
                node.mergeValue = computeRangeValue(node.l, node.r, node.lazyAssign);
            } else {
                node.lazyAdd += delta;
                node.mergeValue = applyAddToValue(node, delta);
            }
            return;
        }
        initChildrenIfNeeded(node);
        pushDown(node);

        int mid = node.l + (node.r - node.l) / 2;
        if (qL <= mid) {
            _rangeAdd(node.left, qL, qR, delta);
        }
        if (qR > mid) {
            _rangeAdd(node.right, qL, qR, delta);
        }
        node.mergeValue = merge(node.left.mergeValue, node.right.mergeValue);
    }

    // 查询闭区间 [qL, qR] 的聚合值
    public int query(int qL, int qR) {
        return _query(root, qL, qR);
    }

    private int _query(SegmentNode node, int qL, int qR) {
        if (node.r < qL || node.l > qR) {
            throw new IllegalArgumentException("Invalid query range");
        }
        if (qL <= node.l && node.r <= qR) {
            return node.mergeValue;
        }

        initChildrenIfNeeded(node);
        pushDown(node);

        int mid = node.l + (node.r - node.l) / 2;
        if (qR <= mid) {
            return _query(node.left, qL, qR);
        } else if (qL > mid) {
            return _query(node.right, qL, qR);
        } else {
            int leftResult = _query(node.left, qL, mid);
            int rightResult = _query(node.right, mid + 1, qR);
            return merge(leftResult, rightResult);
        }
    }
}