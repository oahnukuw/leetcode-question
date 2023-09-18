<p>输入两个链表，找出它们的第一个公共节点。</p>

<p>如下面的两个链表<strong>：</strong></p>

<p><a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" style="height: 130px; width: 400px;" /></a></p>

<p>在节点 c1 开始相交。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png" style="height: 130px; width: 400px;" /></a></p>

<pre><strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
<strong>输出：</strong>Reference of the node with value = 8
<strong>输入解释：</strong>相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png" style="height: 136px; width: 350px;" /></a></p>

<pre><strong>输入：</strong>intersectVal&nbsp;= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>输出：</strong>Reference of the node with value = 2
<strong>输入解释：</strong>相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;3：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png" style="height: 126px; width: 200px;" /></a></p>

<pre><strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>输出：</strong>null
<strong>输入解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
<strong>解释：</strong>这两个链表不相交，因此返回 null。
</pre>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>如果两个链表没有交点，返回 <code>null</code>.</li> 
 <li>在返回结果后，两个链表仍须保持原有的结构。</li> 
 <li>可假定整个链表结构中没有循环。</li> 
 <li>程序尽量满足 O(<em>n</em>) 时间复杂度，且仅用 O(<em>1</em>) 内存。</li> 
 <li>本题与主站 160 题相同：<a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">https://leetcode-cn.com/problems/intersection-of-two-linked-lists/</a></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 691, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [160. 相交链表](/problems/intersection-of-two-linked-lists) 相同。

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

这题难点在于，由于两条链表的长度可能不同，两条链表之间的节点无法对应：

![](https://labuladong.github.io/pictures/链表技巧/5.jpeg)

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，并不能**同时**走到公共节点，也就无法得到相交节点 `c1`。

**解决这个问题的关键是，通过某些方式，让 `p1` 和 `p2` 能够同时到达相交节点 `c1`**。

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，我们可以让 `p1` 遍历完链表 `A` 之后开始遍历链表 `B`，让 `p2` 遍历完链表 `B` 之后开始遍历链表 `A`，这样相当于「逻辑上」两条链表接在了一起。

如果这样进行拼接，就可以让 `p1` 和 `p2` 同时进入公共部分，也就是同时到达相交节点 `c1`：

![](https://labuladong.github.io/pictures/链表技巧/6.jpeg)

另一种思路，先计算两条链表的长度，然后让 `p1` 和 `p2` 距离链表尾部的距离相同，然后齐头并进，

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.github.io/article/fname.html?fname=链表技巧)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == nullptr) {
                p1 = headB;
            } else {
                p1 = p1->next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == nullptr) {
                p2 = headA;
            } else {
                p2 = p2->next;
            }
        }
        return p1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # p1 指向 A 链表头结点，p2 指向 B 链表头结点
        p1, p2 = headA, headB
        while p1 != p2:
            # p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if p1 == None:
                p1 = headB
            else:
                p1 = p1.next
            # p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if p2 == None:
                p2 = headA
            else:
                p2 = p2.next
        return p1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    p1, p2 := headA, headB
    for p1 != p2 {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if p1 == nil {
            p1 = headB
        } else {
            p1 = p1.Next
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if p2 == nil {
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var getIntersectionNode = function(headA, headB) {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    let p1 = headA, p2 = headB;
    while (p1 != p2) {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if (p1 == null) {
            p1 = headB;
        } else {
            p1 = p1.next;
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if (p2 == null) {
            p2 = headA;
        } else {
            p2 = p2.next;
        }
    }
    return p1;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_intersection-of-two-linked-lists" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_intersection-of-two-linked-lists"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>

