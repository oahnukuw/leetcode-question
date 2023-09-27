<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li> 
 <li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> 和 <code>t</code> 由英文字母组成</li> 
</ul>

<p>&nbsp;</p> 
<strong>进阶：</strong>你能设计一个在 
<code>o(n)</code> 时间内解决此问题的算法吗？

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 2224, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-window-substring" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置***/
        printf("window: [%d, %d)n", left, right);
        /********************/

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

具体的算法原理看详细题解吧，这里写不下。

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
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = INT_MAX;/**<extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/1.png) */
        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {/**<extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/2.png) */
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }/**<extend up -50>![](https://labuladong.github.io/pictures/slidingwindow/4.png) */
        }
        // 返回最小覆盖子串
        return len == INT_MAX ?
                "" : s.substr(start, len);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import Counter
        need = Counter(t)
        window = Counter()

        left, right = 0, 0
        valid = 0
        # 记录最小覆盖子串的起始索引及长度
        start, length = 0, float('inf') # <extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/1.png) #
        while right < len(s):
            # c 是将移入窗口的字符
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否要收缩
            while valid == len(need): # <extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/2.png) #
                # 在这里更新最小覆盖子串
                if right - left < length:
                    start = left
                    length = right - left
                # d 是将移出窗口的字符
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1 # <extend up -50>![](https://labuladong.github.io/pictures/slidingwindow/4.png) #
        # 返回最小覆盖子串
        return '' if length == float('inf') else s[start:start+length]
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 采用滑动窗口方法的 Go 解法
func minWindow(s string, t string) string {
    // 将需要匹配的字符及其出现次数存入 need
    // 将滑动窗口中的字符及出现次数存入 window
    need, window := make(map[byte]int), make(map[byte]int)
    for i := range t {
        need[t[i]]++
    }

    left, right := 0, 0 // 定义窗口的左右边界
    valid := 0 // valid 存储满足 need 条件的字符个数
    start, length := 0, math.MaxInt32 // 定义最小覆盖子串的起始位置及长度

    for right < len(s) { // 当右边界小于 s 的长度时
        c := s[right]
        right++

        if _, ok := need[c]; ok { // 如果 c 是需要匹配的字符
            window[c]++
            if window[c] == need[c] {
                valid++
            }
        }

        for valid == len(need) { // 当窗口中已经包含了所有需要的字符时
            if right-left < length { // 更新最小覆盖子串长度及起始位置
                start = left
                length = right - left
            }
            d := s[left]
            left++

            if _, ok := need[d]; ok { // 如果 d 是需要匹配的字符
                if window[d] == need[d] {
                    valid--
                }
                window[d]--
            }
        }
    }

    if length == math.MaxInt32 { // 如果没有符合要求的子串，返回空字符串
        return ""
    }

    return s[start : start+length] // 返回最小覆盖子串
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minWindow = function(s, t) {
    const need = new Map();
    const window = new Map();
    // 统计 t 中每个字符出现的次数
    for (let c of t) {
        need.set(c, need.has(c) ? need.get(c) + 1 : 1)
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录最小覆盖子串的起始索引及长度
    let start = 0, len = Infinity;
    while (right < s.length) {
        // c 是将移入窗口的字符
        let c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, window.has(c) ? window.get(c) + 1 : 1)
            if (window.get(c) === need.get(c))
                valid++;
        }

        // 判断左侧窗口是否要收缩
        while (valid === need.size) {
            // 在这里更新最小覆盖子串
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            // d 是将移出窗口的字符
            let d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d))
                    valid--;
                window.set(d, window.get(d) - 1)
            }
        }
    }
    // 返回最小覆盖子串
    return len === Infinity ?
            "" : s.substr(start, len);
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_minimum-window-substring" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-window-substring"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>





