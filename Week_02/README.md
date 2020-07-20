学习笔记

N叉数的层序遍历利用了广度优先遍历算法(BFS), 搭配额外的List实现记录每层node的目的
广度优先遍历利用队列存储和提取root与leaf nodes实现层级搜索
BFS模板
List<Integer> values = new ArrayList<>();
Queue<Node> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
    Node nextNode = queue.remove();
    values.add(nextNode.val);
    for (Node child : nextNode.children) {
        queue.add(child);
    }
}

TopKFrequent element 算法一
利用hashmap记录各个元素出现频率.
利用本周所学的minheap实现记录最大值的目的(只记录固定数量元素, 删掉root node), 同理Maxheap可以用来记录最小值.
O(Nlogk)
算法二
利用hashmap记录各个元素出现频率.
因为元素数量有限, 因此可以利用桶排序实现时间O(N)复杂度.

