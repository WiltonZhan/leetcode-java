package com.WiltonZhan.leetcode.lcof35FuZaLianBiaoDeFuZhi;

import java.util.HashMap;
import java.util.Map;

/*
剑指 Offer 35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。



示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。


提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。


注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Solution {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node (int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 先复制节点值并建立新老节点的对应关系，再复制random指针指向的值
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        Node temp1 = head, temp2 = newHead;
        // 复制节点值
        while (temp1.next != null) {
            temp2.next = new Node(temp1.next.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
            map.put(temp1, temp2);
        }
        // 复制random
        temp1 = head;
        temp2 = newHead;
        while (temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return newHead;
    }
}
