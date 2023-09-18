<p>输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。</p>

<p><strong>示例1：</strong></p>

<pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
<strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4</pre>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 链表长度 &lt;= 1000</code></p>

<p>注意：本题与主站 21 题相同：<a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">https://leetcode-cn.com/problems/merge-two-sorted-lists/</a></p>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 379, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=he-bing-liang-ge-pai-xu-de-lian-biao-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [21. 合并两个有序链表](/problems/merge-two-sorted-lists) 相同。

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

经典算法题了，[双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 用起来。

![](https://labuladong.github.io/pictures/链表技巧/1.gif)

这个算法的逻辑类似于「拉拉链」，`l1, l2` 类似于拉链两侧的锯齿，指针 `p` 就好像拉链的拉索，将两个有序链表合并。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**，它相当于是个占位符，可以避免处理空指针的情况，降低代码的复杂性。

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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        ListNode* p = dummy;
        ListNode* p1 = l1;
        ListNode* p2 = l2;

        while (p1 != nullptr && p2 != nullptr) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1->val > p2->val) {
                p->next = p2;
                p2 = p2->next;
            } else {
                p->next = p1;
                p1 = p1->next;
            }
            // p 指针不断前进
            p = p->next;
        }

        if (p1 != nullptr) {
            p->next = p1;
        }

        if (p2 != nullptr) {
            p->next = p2;
        }

        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        p = dummy
        p1, p2 = l1, l2
        
        while p1 and p2:
            # 比较 p1 和 p2 两个指针
            # 将值较小的的节点接到 p 指针
            if p1.val > p2.val:
                p.next = p2
                p2 = p2.next
            else:
                p.next = p1
                p1 = p1.next
            # p 指针不断前进
            p = p.next
        
        if p1:
            p.next = p1
        if p2:
            p.next = p2
        
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, nil}
    p := dummy
    p1, p2 := l1, l2

    for p1 != nil && p2 != nil {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if p1.Val > p2.Val {
            p.Next = p2
            p2 = p2.Next
        } else {
            p.Next = p1
            p1 = p1.Next
        }
        // p 指针不断前进
        p = p.Next
    }

    if p1 != nil {
        p.Next = p1
    }

    if p2 != nil {
        p.Next = p2
    }

    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var mergeTwoLists = function(l1, l2) {
    // 虚拟头结点
    let dummy = new ListNode(-1), p = dummy;
    let p1 = l1, p2 = l2;

    while (p1 != null && p2 != null) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if (p1.val > p2.val) {
            p.next = p2;
            p2 = p2.next;
        } else {
            p.next = p1;
            p1 = p1.next;
        }
        // p 指针不断前进
        p = p.next;
    }

    if (p1 != null) {
        p.next = p1;
    }

    if (p2 != null) {
        p.next = p2;
    }

    return dummy.next;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_merge-two-sorted-lists" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-two-sorted-lists"></div></div>
</details><hr /><br />

**类似题目**：
  - [1305. 两棵二叉搜索树中的所有元素 🟠](/problems/all-elements-in-two-binary-search-trees)
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [88. 合并两个有序数组 🟢](/problems/merge-sorted-array)
  - [97. 交错字符串 🟠](/problems/interleaving-string)
  - [977. 有序数组的平方 🟢](/problems/squares-of-a-sorted-array)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>

