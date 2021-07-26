# leet-code

## 刷题顺序
   - Top 100 Liked Questions

## 归纳总结
   - 遇到树相关的优先考虑递归
   - DP相关的，抓住状态转移方程即 找规律 例如 leetcode_5
   - 需要额外数据结构时，可以想想栈stack
   - 回文topic相关的 优先递归
   - 二进制的相关技巧
       - i&1：奇数等于1，偶数等于0
       - n&(n-1)就是把n的最未的1变成0
       - ^ 异或。相同为0，不同为1
           - x^x=0
           - x^0=x
           - a^b^b = a^0 = a
       - 一个数除以2 用位运算>>1代替 更高效
       - x&x-1 ==0 判断x是否是2的n次方
   ### 数组相关
   - 题目中带有sorted的，优先想到二分法例如 LeetCode34 题
   - 题目中包含2倍相关的，优先想到是否可以使用快慢指针 例如Leetcode1470
   - 暴力破解时间复杂度高，可以尝试用map空间换时间

   ### 递归排序
   - 时间复杂度 O(nlogn)
   - 思路与步骤 例如 LeetCode148
        - 明确什么时候可以使用
        - 获取递推关系
        - 确定终止条件  
   ### 回溯
```
result = []
参考 https://labuladong.gitee.io/algo/4/29/93/
// help 函数
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择

```


## 如何科学刷 Leet-Code
  - 看懂题目
  - 分析，推导解法
  - 将思路转换为代码
  - 坚持
  - 按照 tag来刷，刷完总结题型(约到后面会觉得，这题我竟然也可以不看答案做出来)

## 为什么刷题

        
        
## 其他
  - IDEA中推荐安装 `leetcode editor` 插件
        

        