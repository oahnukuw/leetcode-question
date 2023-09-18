<p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], n = 2
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [1], n = 1
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], n = 1
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中结点的数目为 <code>sz</code></li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 2671, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=remove-nth-node-from-end-of-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.github.io/pictures/链表技巧/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.github.io/pictures/链表技巧/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.github.io/pictures/链表技巧/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != NULL) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1 != None:
            p1 = p1.next
            p2 = p2.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{Val: -1, Next: head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n + 1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1, p2 := head, head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p1 = p1.Next
        p2 = p2.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    let dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    let x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
var findFromEnd = function(head, k) {
    let p1 = head;
    // p1 先走 k 步
    for (let i = 0; i < k; i++) {
        p1 = p1.next;
    }
    let p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 != null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
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

