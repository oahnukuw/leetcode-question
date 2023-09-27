<p>给定一个已排序的链表的头
 <meta charset="UTF-8" />&nbsp;<code>head</code>&nbsp;，&nbsp;<em>删除所有重复的元素，使每个元素只出现一次</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="height: 160px; width: 200px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2]
<strong>输出：</strong>[1,2]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="height: 123px; width: 300px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2,3,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>题目数据保证链表已经按升序 <strong>排列</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1042, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicates-from-sorted-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.github.io/pictures/数组去重/2.gif)

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* deleteDuplicates(ListNode* head) {  // 删除链表中重复的元素
        if (head == NULL) return NULL;  // 如果链表为空，直接返回NULL
        ListNode *slow = head, *fast = head;  // 定义快慢指针，初始都指向头结点
        while (fast != NULL) {  // 只要快指针没有遍历完整个链表
            if (fast->val != slow->val) {  // 快慢指针值不同
                slow->next = fast;  // 慢指针连接新节点
                slow = slow->next;  // 慢指针向后移动一位
            }
            fast = fast->next;  // 快指针向后移动一位
        }
        slow->next = NULL;  // 断开与后面重复元素的连接
        return head;  // 返回头结点
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        slow = head
        fast = head
        while fast != None:
            if fast.val != slow.val:
                # nums[slow] = nums[fast];
                slow.next = fast
                # slow++;
                slow = slow.next
            # fast++
            fast = fast.next
        # 断开与后面重复元素的连接
        slow.next = None
        return head
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    slow, fast := head, head
    for fast != nil {
        if fast.Val != slow.Val {
            // nums[slow] = nums[fast];
            slow.Next = fast
            // slow++;
            slow = slow.Next
        }
        // fast++
        fast = fast.Next
    }
    // 断开与后面重复元素的连接
    slow.Next = nil
    return head
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
var deleteDuplicates = function(head) {
  if (head === null) return null;
  var slow = head;
  var fast = head;
  while (fast !== null) {
    if (fast.val !== slow.val) {
      // nums[slow] = nums[fast];
      slow.next = fast;
      // slow++;
      slow = slow.next;
    }
    // fast++
    fast = fast.next;
  }
  // 断开与后面重复元素的连接
  slow.next = null;
  return head;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [82. 删除排序链表中的重复元素 II 🟠](/problems/remove-duplicates-from-sorted-list-ii)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>

