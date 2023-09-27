<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong>异位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p><strong>异位词 </strong>指由相同字母重排列形成的字符串（包括相同的字符串）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "cbaebabacd", p = "abc"
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "abab", p = "ab"
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 1039, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=find-all-anagrams-in-a-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

这题和 [567. 字符串的排列](/problems/permutation-in-string) 一样，只不过找到一个合法异位词（排列）之后将它的起始索引加入结果列表即可。

滑动窗口算法难度略高，具体的算法原理以及算法模板见详细题解。

**详细题解：[我写了首诗，把滑动窗口算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=滑动窗口技巧进阶)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> findAnagrams(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        vector<int> res; // 记录结果
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.push_back(left);
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }
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
    def findAnagrams(self, s: str, t: str) -> List[int]:
        need = {}
        window = {}
        for c in t:
            if c in need:
                need[c] += 1
            else:
                need[c] = 1

        left = 0
        right = 0
        valid = 0
        res = []
        
        while right < len(s):
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                if c in window:
                    window[c] += 1
                else:
                    window[c] = 1
                if window[c] == need[c]:
                    valid += 1
            # 判断左侧窗口是否要收缩
            while right - left >= len(t):
                # 当窗口符合条件时，把起始索引加入 res
                if valid == len(need):
                    res.append(left)
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.add(left);
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
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

func findAnagrams(s string, t string) []int {
    need := make(map[byte]int)
    window := make(map[byte]int)
    for i := 0; i < len(t); i++ {
        need[t[i]]++
    }

    left, right := 0, 0
    valid := 0
    var res []int
    for right < len(s) {
        c := s[right]
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c]++
            if window[c] == need[c] {
                valid++
            }
        }
        // 判断左侧窗口是否要收缩
        for right - left >= len(t) {
            // 当窗口符合条件时，把起始索引加入 res
            if valid == len(need) {
                res = append(res, left)
            }
            d := s[left]
            left++
            // 进行窗口内数据的一系列更新
            if _, ok := need[d]; ok {
                if window[d] == need[d] {
                    valid--
                }
                window[d]--
            }
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @param {string} t
 * @return {number[]}
 */
var findAnagrams = function(s, t) {
    const need = new Map();
    const window = new Map();
    for (const c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    const res = [];

    while (right < s.length) {
        const c = s[right];
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }
        // 判断左侧窗口是否要收缩
        while (right - left >= t.length) {
            // 当窗口符合条件时，把起始索引加入 res
            if (valid === need.size) {
                res.push(left);
            }
            const d = s[left];
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_find-all-anagrams-in-a-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-anagrams-in-a-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>





