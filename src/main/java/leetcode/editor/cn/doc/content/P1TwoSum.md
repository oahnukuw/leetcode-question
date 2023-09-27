<p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>

<p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>

<p>你可以按任意顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[0,1]
<strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,4], target = 6
<strong>输出：</strong>[1,2]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,3], target = 6
<strong>输出：</strong>[0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
 <li><strong>只会存在一个有效答案</strong></li> 
</ul>

<p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表</details><br>

<div>👍 15425, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=two-sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

大家都喜欢幽默的人，如果你想调侃自己经常拖延，可以这样调侃下自己（手动狗头）：

背单词背了半年还是 abandon, abandon，刷题刷了半年还是 two sum, two sum...

言归正传，这道题不难，但由于它是 LeetCode 第一题，所以名气比较大，解决这道题也可以有多种思路，我这里说两种最常见的思路。

第一种思路就是靠排序，把 `nums` 排序之后就可以用 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中讲到的左右指针来求出和为 `target` 的两个数。

不过因为题目要求我们返回元素的索引，而排序会破坏元素的原始索引，所以要记录值和原始索引的映射。

进一步，如果题目拓展延伸一下，让你求三数之和、四数之和，你依然可以用双指针技巧，我在 [一个函数秒杀 nSum 问题](https://labuladong.github.io/article/fname.html?fname=nSum) 中写一个函数来解决所有 N 数之和问题。

第二种思路是用哈希表辅助判断。对于一个元素 `nums[i]`，你想知道有没有另一个元素 `nums[j]` 的值为 `target - nums[i]`，这很简单，我们用一个哈希表记录每个元素的值到索引的映射，这样就能快速判断数组中是否有一个值为 `target - nums[i]` 的元素了。

简单说，数组其实可以理解为一个「索引 -> 值」的哈希表映射，而我们又建立一个「值 -> 索引」的映射即可完成此题。

**详细题解：[一个方法团灭 nSum 问题](https://labuladong.github.io/article/fname.html?fname=nSum)**

**标签：[双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 维护 val -> index 的映射
        unordered_map<int, int> valToIndex;
        for (int i = 0; i < nums.size(); i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.count(need)) {
                return vector<int>{valToIndex[need], i};
            }
            // 存入 val -> index 的映射
            valToIndex[nums[i]] = i;
        }
        return vector<int>{};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 维护 val -> index 的映射
        valToIndex = {}
        for i in range(len(nums)):
            # 查表，看看是否有能和 nums[i] 凑出 target 的元素
            need = target - nums[i]
            if need in valToIndex:
                return [valToIndex[need], i]
            # 存入 val -> index 的映射
            valToIndex[nums[i]] = i
        return []
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func twoSum(nums []int, target int) []int {
    // 维护 val -> index 的映射
    valToIndex := make(map[int]int)

    for i, num := range nums {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        need := target - num
        if valToIndex[need] != 0 {
            return []int{valToIndex[need] - 1, i}
        }
        // 存入 val -> index 的映射
        valToIndex[num] = i + 1
    }

    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var twoSum = function(nums, target) {
    // 维护 val -> index 的映射
    var valToIndex = new Map();
    for (var i = 0; i < nums.length; i++) {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        var need = target - nums[i];
        if (valToIndex.has(need)) {
            return [valToIndex.get(need), i];
        }
        // 存入 val -> index 的映射
        valToIndex.set(nums[i], i);
    }
    return null;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_two-sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_two-sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [15. 三数之和 🟠](/problems/3sum)
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [18. 四数之和 🟠](/problems/4sum)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 007. 数组中和为 0 的三个数 🟠](/problems/1fGaJU)

</details>
</div>







