<p>给你一个链表的头节点 <code>head</code> ，判断链表中是否有环。</p>

<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。<strong>注意：<code>pos</code> 不作为参数进行传递&nbsp;</strong>。仅仅是为了标识链表的实际情况。</p>

<p><em>如果链表中存在环</em>&nbsp;，则返回 <code>true</code> 。 否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>false
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围是 <code>[0, 10<sup>4</sup>]</code></li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 为 <code>-1</code> 或者链表中的一个 <strong>有效索引</strong> 。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能用 <code>O(1)</code>（即，常量）内存解决此问题吗？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 1987, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=linked-list-cycle" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

经典题目了，要使用双指针技巧中的快慢指针，每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步。

如果 `fast` 最终遇到空指针，说明链表中没有环；如果 `fast` 最终和 `slow` 相遇，那肯定是 `fast` 超过了 `slow` 一圈，说明链表中含有环。

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
    bool hasCycle(ListNode *head) {
        // 快慢指针初始化指向 head
        ListNode *slow = head, *fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        # 快慢指针初始化指向 head
        slow, fast = head, head
        # 快指针走到末尾时停止
        while fast and fast.next:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
            # 快慢指针相遇，说明含有环
            if slow == fast:
                return True
        # 不包含环
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func hasCycle(head *ListNode) bool {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
        // 快慢指针相遇，说明含有环
        if slow == fast {
            return true
        }
    }
    // 不包含环
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
        // 快慢指针相遇，说明含有环
        if (slow === fast) {
            return true;
        }
    }
    // 不包含环
    return false;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_linked-list-cycle" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle"></div></div>
</details><hr /><br />

**类似题目**：
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
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

