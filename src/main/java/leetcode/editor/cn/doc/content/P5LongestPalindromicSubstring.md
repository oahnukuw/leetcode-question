<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> 仅由数字和英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 5763, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=longest-palindromic-substring" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 373 页。

**寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串**，对于最长回文子串，就是这个意思：

```python
for 0 <= i < len(s):
    找到以 s[i] 为中心的回文串
    更新答案
```

找回文串的关键技巧是传入两个指针 `l` 和 `r` 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。

```python
for 0 <= i < len(s):
    # 找到以 s[i] 为中心的回文串
    palindrome(s, i, i)
    # 找到以 s[i] 和 s[i+1] 为中心的回文串
    palindrome(s, i, i + 1)
    更新答案
```

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：中心向两端的双指针，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            string s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            string s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    string palindrome(string s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s[l] == s[r]) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substr(l + 1, r - l - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # 以 s[i] 为中心的最长回文子串
            s1 = self.palindrome(s, i, i)
            # 以 s[i] 和 s[i+1] 为中心的最长回文子串
            s2 = self.palindrome(s, i, i + 1)
            # res = longest(res, s1, s2)
            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2
        return res

    def palindrome(self, s: str, l: int, r: int) -> str:
        # 防止索引越界
        while l >= 0 and r < len(s) and s[l] == s[r]:
            # 向两边展开
            l -= 1
            r += 1
        # 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s[l+1:r]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func longestPalindrome(s string) string {
    res := ""
    for i := 0; i < len(s); i++ {
        // 以 s[i] 为中心的最长回文子串
        s1 := palindrome(s, i, i)
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        s2 := palindrome(s, i, i+1)
        // res = longest(res, s1, s2)
        if len(s1) > len(res) {
            res = s1
        }
        if len(s2) > len(res) {
            res = s2
        }
    }
    return res
}

func palindrome(s string, l, r int) string {
    // 防止索引越界
    for l >= 0 && r < len(s) && s[l] == s[r] {
        // 向两边展开
        l--
        r++
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s[l+1 : r]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var longestPalindrome = function(s) {
    let res = "";
    for (let i = 0; i < s.length; i++) {
        // 以 s[i] 为中心的最长回文子串
        let s1 = palindrome(s, i, i);
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        let s2 = palindrome(s, i, i + 1);
        // res = longest(res, s1, s2)
        res = res.length > s1.length ? res : s1;
        res = res.length > s2.length ? res : s2;
    }
    return res;

    function palindrome(s, l, r) {
        // 防止索引越界
        while (l >= 0 && r < s.length
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_longest-palindromic-substring" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-palindromic-substring"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [658. 找到 K 个最接近的元素 🟠](/problems/find-k-closest-elements)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>







