<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "abcabcbb"
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <span><code>"abc"，所以其</code></span>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "bbbbb"
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <span><code>"b"</code></span>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = "pwwkew"
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<span><code>"wke"</code></span>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<span><code>"pwke"</code></span>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 8214, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=longest-substring-without-repeating-characters" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

这题比其他滑动窗口的题目简单，连 `need` 和 `valid` 都不需要，而且更新窗口内数据也只需要简单的更新计数器 `window` 即可。

当 `window[c]` 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 `left` 缩小窗口了。

另外，要在收缩窗口完成后更新 `res`，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。

**详细题解：[我写了首诗，把滑动窗口算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=滑动窗口技巧进阶)**

**标签：[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
class Solution {
    public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;
            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                window[d]--;
            }
            // 在这里更新答案
            res = max(res, right - left);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = {}

        left = right = 0
        res = 0 # 记录结果
        while right < len(s):
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            window[c] = window.get(c, 0) + 1
            # 判断左侧窗口是否要收缩
            while window[c] > 1:
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                window[d] -= 1
            # 在这里更新答案
            res = max(res, right - left)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func lengthOfLongestSubstring(s string) int {
    window := make(map[byte]int)

    left, right := 0, 0
    res := 0 // 记录结果
    for right < len(s) {
        c := s[right]
        right++
        // 进行窗口内数据的一系列更新
        window[c]++
        // 判断左侧窗口是否要收缩
        for window[c] > 1 {
            d := s[left]
            left++
            // 进行窗口内数据的一系列更新
            window[d]--
        }
        // 在这里更新答案
        res = max(res, right - left)
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var lengthOfLongestSubstring = function(s) {
    let window = new Map();
    let left = 0, right = 0, res = 0;
    while (right < s.length) {
        let c = s[right];
        right++;
        // 进行窗口内数据的一系列更新
        window.set(c, (window.get(c) || 0) + 1);
        // 判断左侧窗口是否要收缩
        while (window.get(c) > 1) {
            let d = s[left];
            left++;
            // 进行窗口内数据的一系列更新
            window.set(d, window.get(d) - 1);
        }
        // 在这里更新答案
        res = Math.max(res, right - left);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_longest-substring-without-repeating-characters" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-substring-without-repeating-characters"></div></div>
</details><hr /><br />

**类似题目**：
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>







