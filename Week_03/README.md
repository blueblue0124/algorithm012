# 学习笔记
1. 二叉树的最近公共祖先:
    - 树的问题通常可以用递归来解决.
    - 特殊的递归终止条件 
        ```if(root == null || root.val == q || root.val == p)```
    - 子问题: 分别在左子树和右子树寻找p和q.
    - 时间复杂度**O(n)**, 空间复杂度**O(n)**(最糟糕栈深度).
2.  全排列: 
    - 深度优先搜索(DFS), 迭代 
    - 给定数组无重复元素, 无需剪枝.
    - 使用used[]数组记录元素使用情况. 完成一次迭代需要进行回溯(backtracking, reverse previous state).
    - 在返回一组答案时需要重新生成答案(copy). ``` res.add(new ArrayList<>(path)); ```
3. 全排列2:
    - 主体与上面的全排列相同.
    - 由于给定数组中有重复元素需要进行剪枝去重(画图分析很重要) ``` if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false) continue;  ```