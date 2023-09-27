<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0,1,0,3,12]</code></span>
<strong>输出:</strong> <span><code>[1,3,12,0,0]</code></span>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0]</code></span>
<strong>输出:</strong> <span><code>[0]</code></span></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2170, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=move-zeroes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
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
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0
            
    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums: List[int], val: int) -> int:
        fast = 0
        slow = 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
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

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast := 0
    slow := 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
};

// 双指针技巧，复用 [27. 移除元素] 的解法。
var removeElement = function(nums, val) {
    var fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_move-zeroes" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>

