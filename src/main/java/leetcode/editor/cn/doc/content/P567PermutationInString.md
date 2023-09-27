<p>给你两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code> ，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的排列。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>换句话说，<code>s1</code> 的排列之一是 <code>s2</code> 的 <strong>子串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s1 = "ab" s2 = "eidbaooo"
<strong>输出：</strong>true
<strong>解释：</strong>s2 包含 s1 的排列之一 ("ba").
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s1= "ab" s2 = "eidboaoo"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>

<div>👍 786, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=permutation-in-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

和子数组/子字符串相关的题目，很可能就是要考察滑动窗口算法，往这方面思考就行了。

这道题，相当于你一个 `S` 和一个 `T`，请问你 `S` 中是否存在一个子串，包含 `T` 中所有字符且不包含其他字符？

如果这样想的话就和 [76. 最小覆盖子串](/problems/minimum-window-substring) 有些类似了。

一般来说滑动窗口算法难度略高，需要你掌握算法原理以及算法模板辅助，见详细题解吧。

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

    // 判断 s 中是否存在 t 的排列
    bool checkInclusion(string t, string s) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
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
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
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
        // 未找到符合条件的子串
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def checkInclusion(self, t: str, s: str) -> bool:
        # 创建字典，记录字符需要出现的次数
        need, window = Counter(t), Counter()
        left, right, valid = 0, 0, 0
        
        # 右指针前移，更新窗口内数据
        while right < len(s):
            c = s[right]
            right += 1
            # 如果该字符在需要的字典里，更新窗口内字典
            if need[c]:
                window[c] += 1
                # 如果窗口内字典该字符准确次数与需要的次数相同，计数器+1
                if window[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否需要收缩
            while right - left >= len(t):
                # 如果子串合法，返回True
                if valid == len(need):
                    return True
                # 左指针前移了，需要从窗口内字典中减掉一个元素
                d = s[left]
                left += 1
                if need[d]:
                    # 如果窗口内字典该字符准确次数与需要的次数相同，计数器-1
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        # 未找到合法的子串，返回False
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public boolean checkInclusion(String t, String s) {
        //使用哈希表用于记录 t 中每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //初始化窗口的左右边界及合法字符个数
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                //在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;

                //进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //未找到符合条件的子串
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 判断 s 中是否存在 t 的排列
func checkInclusion(t string, s string) bool {
    need, window := make(map[byte]int), make(map[byte]int)
    for i := range t {
        need[t[i]]++
    }

    left, right := 0, 0
    valid := 0
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
        for right-left >= len(t) {
            // 在这里判断是否找到了符合条件的子串
            if valid == len(need) {
                return true
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
    // 未找到符合条件的子串
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var checkInclusion = function(t, s) {
    // 初始化 need 和 window 哈希表
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0;
    let right = 0;
    let valid = 0;
    while (right < s.length) {
        let c = s[right];
        right++;
        // 进行窗口内数据的更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }

        // 判断左侧窗口是否需要收缩
        while (right - left >= t.length) {
            // 更新结果
            if (valid === need.size) {
                return true;
            }
            let d = s[left];
            left++;
            // 进行窗口内数据的更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, (window.get(d) || 0) - 1);
            }
        }
    }
    // 未找到符合条件的子串
    return false;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_permutation-in-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutation-in-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>





