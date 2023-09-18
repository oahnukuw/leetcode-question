<p>给你单链表的头结点 <code>head</code> ，请你找出并返回链表的中间结点。</p>

<p>如果有两个中间结点，则返回第二个中间结点。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[3,4,5]
<strong>解释：</strong>链表只有一个中间结点，值为 3 。
</pre>

<p><strong class="example">示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5,6]
<strong>输出：</strong>[4,5,6]
<strong>解释：</strong>该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表的结点数范围是 <code>[1, 100]</code></li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 936, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=middle-of-the-linked-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：

我们让两个指针 `slow` 和 `fast` 分别指向链表头结点 `head`。

**每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步，这样，当 `fast` 走到链表末尾时，`slow` 就指向了链表中点**。

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
    ListNode* middleNode(ListNode* head) {
        // 快慢指针初始化指向 head
        ListNode* slow = head;
        ListNode* fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
        }
        // 慢指针指向中点
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
    def middleNode(self, head: ListNode) -> ListNode:
        # 快慢指针初始化指向 head
        slow = fast = head
        # 快指针走到末尾时停止
        while fast and fast.next:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
        # 慢指针指向中点
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func middleNode(head *ListNode) *ListNode {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
    }
    // 慢指针指向中点
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var middleNode = function(head) {
  // 快慢指针初始化指向 head
  let slow = head, fast = head;
  // 快指针走到末尾时停止
  while (fast != null && fast.next != null) {
    // 慢指针走一步，快指针走两步
    slow = slow.next;
    fast = fast.next.next;
  }
  // 慢指针指向中点
  return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_middle-of-the-linked-list" data="G+0fEdWaowG0OuANpca/BaUew0Bs4AI9l+grMxbM68iuBy1FUnZec00789JBp2QYouKX+duzWC7sboPxUwZKsfIMLQ41OZ9/WdXu65EBtwt05D8MEWl3HvdNycoOHDzziBxa7aGUaBCTlx5+/Vq5LjdHswHADhqD8u5cUh5I2K3u/vuCOAGg8pmevzMhYiPIRcXJaDfrXMAX2ez3MLn7QkrqEOjKdIuzwPM2LXZzZJfYt9gteIeBCzVrcQ5WJL6+GOzFwkwU/8a/PzfrFi9gEX9SxMImulWX/ip0dSK+m1lFOohlCi44rV2gr/6yGWCY4IjrQZnF2s8Opoo9hWKuwPYjNeBaT1+qpzcLJww/L+MEpq07HT99awW5OJyKfTGVI7F3G/2LTbSoI175oeraRP9+yMnXd4ddZGBnnw2D3+scfdn5kS5bZle9Q7jjsWyNSsLMOdvOcdsGds+4r918gTcvmWk9k7ute/B2aLS91fR1pr/L84VOqG+bkHdZxamjV5HsSWFn+gTHWHN6/GVF3Wp6LKBbT6HxRu6iC7uSV28Z9C6KXwNnBhcGFw+C7Pk1S5iVt0yU4Dl3yuIAFxtSsyX7n5+E9qPfHr/7Ylp/FALXtokr0T/ftvqSMrQWofOBQ3oMEgOVODZuhTgPjPLQtcj8mlVPhITW6fGfaYGkfMs+VFUfoH/+Akf2BTikxx9dseX6Bs2qCdA6Pf4zJeCob9kH3+oD9M9d4Mi+AIdUgKfke4JWx37S485jHrDBsLJR35TwHBx8+UPOWd5HsCO5ybXLzzYz6OmGTFqYoAa0zNjCHSA55J1wDtZ5ydfBsiMWwGXnWIDaoAU4yIAECmgQeqqkcN+uv9fBW/jBDPPCPPo/F9RtyDMR0KwcKpSZdYb9DMIMM2nHYzZkpghb2MysgEBiEHroZlZADDcI2UA7A8/fPELkX8vF2xvozE8a9LyaXOw6HQZodshJMq9TdpehCYrwbXViTDPTjHKSR5hRNQcGZxQWkOyMmrwYPf3UjUZcc1wvx7U9awzePBZnSIsLFxeEyDFcl9POZtK179S7iiaR1S8+7xzWpuuHmt6hjTjJhsguuIVMGel62hIFYaeob/iWHjuaodbozstiJAQQAj2VioKYQ+3K+SvRkvlurGQJRUeG8hB6IhgFeQWzyLn1507qUNem6CaDxIVf4pp1rXm+52CM6tRIrAhLelIfJQ3LVNOLzLeipDLxnBkUDZEl2riL86MnS6FnfbwBFLQVo0jykaKiAjX2yIqcoIhiY6lyVuQEOu0BM5N8rQk1kVczIIUlicM2rny1+UP6tbof6RhEFJ97T6CTzVDQzb5+OrdTtzktJzqARAw7CpwBOu6YXQdnO877dcVz6Djg4cW9vKx44CCGDsaXfE39WgQpkkQGOvk5/cAAAvOVLwJZPTQAo5NHwQHhINexCYyGngGz8oCwIDY4GCfPk4Spp2mCkedI5AEs/DGHVbXprDqKXdEWHaTQJzLa77WIqegU5xVFnnzjnMycOhMzQzcs4nlvVYh+/sCGC1OMlIaE+bzPjkLVzQk5T7lhdkAHV41q1tu/iQ01nh13b15aMkbgHkoFJZnTQ24/SV2lXrmHIok7yA6l8NC25yfn6Y+FgKOtM8O6r5/O6VPQVHJAVnco7IdajPauA5O2JjXyMyFtITdNCkNHXwzVXOymk0nN5ILTKuNb8K5dgihdnewLQrcvIKtboTsVLalQJaBLXkRFglJS+hAa3qhJjTFf+CIHG5K56rb3Mb2rL9BZ9XlGihOXC37vNhbuHhDcKYRcih2IFTF137V0+1n8hmjnJUJAtIBY5gOEOwuIbj5AMIOBrfxlSRCzLCBNWVihCbCykQVEIAtIOhZWoAEWvhwhyGUSVHphVSdMj+HjiPmYAJcx7mdc2fqF9THrr8q5TsJZlbAMqoarKhoCg6BuYFC0RcTg0OAYBHWJQdEWGwaHBmGYg7YrcoQXl+WU8Njhp80vxklyvxxnWfqKvVb15zX1ov1FKCg1XGFaFJUPOdFEbVTd9b315r6cr7WpC06Ym3Q/911SIJdmybt5l6LLtdbPPpo5uNwJS5UjPwm+MqFsRmm1U976ctX3c/9f1FAJQdOVnFHln8JWjbhgZWpoF1cw52W0jbpB6XcLf/QZ9S4I0vN6c17+ES1LdxsuS+Cn+sXOrV/jmx9MwtGQEGKnXu/Ff/zeo34igdIl/osfysLoddPT+fk4N/IX"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_middle-of-the-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>

