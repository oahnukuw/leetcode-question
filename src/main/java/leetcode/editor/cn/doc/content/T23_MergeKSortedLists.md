<p>给你一个链表数组，每个链表都已经按升序排列。</p>

<p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
<strong>输出：</strong>[1,1,2,3,4,4,5,6]
<strong>解释：</strong>链表数组如下：
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
将它们合并到一个有序链表中得到。
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>lists = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>lists = [[]]
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>k == lists.length</code></li> 
 <li><code>0 &lt;= k &lt;= 10^4</code></li> 
 <li><code>0 &lt;= lists[i].length &lt;= 500</code></li> 
 <li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li> 
 <li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li> 
 <li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表 | 分治 | 堆（优先队列） | 归并排序</details><br>

<div>👍 2613, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=merge-k-sorted-lists" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

[21. 合并两个有序链表](/problems/merge-two-sorted-lists) 的延伸，利用 [优先级队列（二叉堆）](https://labuladong.github.io/article/fname.html?fname=二叉堆详解实现优先级队列) 进行节点排序即可。

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.github.io/article/fname.html?fname=链表技巧)**

**标签：二叉堆，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int size = lists.size();
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        ListNode* p = dummy;
        // 优先级队列，最小堆
        priority_queue<ListNode*, vector<ListNode*>, compare > pq;
        // 将 k 个链表的头结点加入最小堆
        for (auto head : lists) {
            if (head) pq.push(head);
        }

        while (!pq.empty()) {
            // 获取最小节点，接到结果链表中
            auto node = pq.top();
            pq.pop();
            p->next = node;
            if (node->next) {
                pq.push(node->next);
            }
            // p 指针不断前进
            p = p->next;
        }
        return dummy->next;
    }
private:
    // 自定义比较函数
    struct compare {
        bool operator() (ListNode* a, ListNode* b) {
            return a->val > b->val;
        }
    };
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return None
        # 虚拟头结点
        dummy = ListNode(-1)
        p = dummy
        # 优先级队列，最小堆
        pq = []
        for head in lists:
            if head:
                heapq.heappush(pq, (head.val, id(head), head))
        # 将 k 个链表的头结点加入最小堆
        while pq:
            # 获取最小节点，接到结果链表中
            node = heapq.heappop(pq)[2]
            p.next = node
            if node.next:
                heapq.heappush(pq, (node.next.val, id(node.next), node.next))
            # p 指针不断前进
            p = p.next
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

//Definition for singly-linked list.

func mergeKLists(lists []*ListNode) *ListNode {
    if len(lists) == 0 {
        return nil
    }
    // 虚拟头节点
    dummy := &ListNode{Val: -1}
    p := dummy
    // 优先队列,最小堆, 用golang的heap
    pq := make(Queue, len(lists))
    for i, head := range lists {
        if head != nil {
            pq[i] = head
        }
    }
    heap.Init(&pq)

    for pq.Len() != 0 {
        // 获取最小节点，接到结果链表中
        node := heap.Pop(&pq).(*ListNode)
        p.Next = node
        if node.Next != nil {
            heap.Push(&pq, node.Next)
        }
        // p 指针不断前进
        p = p.Next
    }
    return dummy.Next
}

// golang的堆排序Queue
type Queue []*ListNode

func (q Queue) Len() int { return len(q) }

func (q Queue) Less(i, j int) bool {
    return q[i].Val < q[j].Val
}

func (q Queue) Swap(i, j int) {
    q[i], q[j] = q[j], q[i]
}

func (q *Queue) Push(x interface{}) {
    *q = append(*q, x.(*ListNode))
}

func (q *Queue) Pop() interface{} {
    old := *q
    n := len(old)
    x := old[n-1]
    *q = old[:n-1]
    return x
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
* @param {ListNode[]} lists
* @return {ListNode}
*/
var mergeKLists = function(lists) {
    if (lists.length == 0) return null;
    // 虚拟头结点
    let dummy = new ListNode(-1);
    let p = dummy;
    // 优先级队列，最小堆
    let pq = new PriorityQueue(
        lists.length, (a, b) => (a.val - b.val));
    // 将 k 个链表的头结点加入最小堆
    for (let head of lists) {
        if (head != null)
            pq.add(head);
    }

    while (!pq.isEmpty()) {
        // 获取最小节点，接到结果链表中
        let node = pq.poll();
        p.next = node;
        if (node.next != null) {
            pq.add(node.next);
        }
        // p 指针不断前进
        p = p.next;
    }
    return dummy.next;
};
```

</div></div>
</div></div>

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [355. 设计推特 🟠](/problems/design-twitter)
  - [373. 查找和最小的 K 对数字 🟠](/problems/find-k-pairs-with-smallest-sums)
  - [378. 有序矩阵中第 K 小的元素 🟠](/problems/kth-smallest-element-in-a-sorted-matrix)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 061. 和最小的 k 个数对 🟠](/problems/qn8gGX)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>

