<p>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>nums =&nbsp;[1,2,3,4]
<strong>输出：</strong>[1,3,2,4] 
<strong>注：</strong>[3,1,2,4] 也是正确的答案之一。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>0 &lt;= nums.length &lt;= 50000</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 10000</code></li> 
</ol>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 324, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题是前文 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 讲到的快慢指针技巧，可以复用 [27. 移除元素（简单）](/problems/remove-element) 解法中的函数，只要稍微修改一下逻辑即可。

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> exchange(vector<int>& nums) {
        // 维护 nums[0..slow) 都是奇数
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] % 2 == 1) {
                // fast 遇到奇数，把 nums[fast] 换到 nums[slow]
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def exchange(self, nums: List[int]) -> List[int]:
        # 维护 nums[0..slow) 都是奇数
        fast, slow = 0, 0
        while fast < len(nums):
            if nums[fast] % 2 == 1:
                # fast 遇到奇数，把 nums[fast] 换到 nums[slow]
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1
            fast += 1
        return nums
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] exchange(int[] nums) {
        // 维护 nums[0..slow) 都是奇数
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                // fast 遇到奇数，把 nums[fast] 换到 nums[slow]
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func exchange(nums []int) []int {
    // 维护 nums[0..slow) 都是奇数
    fast, slow := 0, 0
    for fast < len(nums) {
        if nums[fast]%2 == 1 {
            // fast 遇到奇数，把 nums[fast] 换到 nums[slow]
            temp := nums[slow]
            nums[slow] = nums[fast]
            nums[fast] = temp
            slow++
        }
        fast++
    }
    return nums
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var exchange = function(nums) {
    // 维护 nums[0..slow) 都是奇数
    let fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] % 2 === 1) {
            // fast 遇到奇数，把 nums[fast] 换到 nums[slow]
            let temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            slow++;
        }
        fast++;
    }
    return nums;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof"></div></div>
</details><hr /><br />

</details>
</div>

