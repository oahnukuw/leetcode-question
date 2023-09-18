<p>给定一个链表的头节点 &nbsp;<code>head</code>&nbsp;，返回链表开始入环的第一个节点。&nbsp;<em>如果链表无环，则返回&nbsp;<code>null</code>。</em></p>

<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（<strong>索引从 0 开始</strong>）。如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意：<code>pos</code> 不作为参数进行传递</strong>，仅仅是为了标识链表的实际情况。</p>

<p><strong>不允许修改 </strong>链表。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>返回索引为 1 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>返回索引为 0 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>返回 null
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围在范围 <code>[0, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 的值为 <code>-1</code> 或者链表中的一个有效索引</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你是否可以使用 <code>O(1)</code> 空间解决此题？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 2315, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=linked-list-cycle-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

基于 [141. 环形链表](/problems/linked-list-cycle) 的解法，直观地来说就是当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。

原理也简单说下吧，我们假设快慢指针相遇时，慢指针 `slow` 走了 `k` 步，那么快指针 `fast` 一定走了 `2k` 步：

![](https://labuladong.github.io/pictures/双指针/3.jpeg)

`fast` 一定比 `slow` 多走了 `k` 步，这多走的 `k` 步其实就是 `fast` 指针在环里转圈圈，所以 `k` 的值就是环长度的「整数倍」。

假设相遇点距环的起点的距离为 `m`，那么结合上图的 `slow` 指针，环的起点距头结点 `head` 的距离为 `k - m`，也就是说如果从 `head` 前进 `k - m` 步就能到达环起点。

巧的是，如果从相遇点继续前进 `k - m` 步，也恰好到达环起点：

![](https://labuladong.github.io/pictures/双指针/2.jpeg)

所以，只要我们把快慢指针中的任一个重新指向 `head`，然后两个指针同速前进，`k - m` 步后一定会相遇，相遇之处就是环的起点了。

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
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast, *slow;
        fast = slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == nullptr || fast->next == nullptr) {
            // fast 遇到空指针说明没有环
            return nullptr;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast->next;
            slow = slow->next;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break # <extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) #
        if not fast or not fast.next:
            return None
        
        slow = head # <extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) #
        while slow != fast:
            slow = slow.next
            fast = fast.next
        
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func detectCycle(head *ListNode) *ListNode {
    fast, slow := head, head
    for fast != nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == slow {
            break/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
    }
    if fast == nil || fast.Next == nil {
        return nil
    }
    slow = head/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
    for slow != fast {
        slow = slow.Next
        fast = fast.Next
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    let fast = head, slow = head;
    while (fast !== null && fast.next !== null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast === slow) {
            break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
    }
    // 上面的代码类似 hasCycle 函数
    if (fast === null || fast.next === null) {
        // fast 遇到空指针说明没有环
        return null;
    }

    // 重新指向头结点
    slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
    // 快慢指针同步前进，相交点就是环起点
    while (slow !== fast) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_linked-list-cycle-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
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



