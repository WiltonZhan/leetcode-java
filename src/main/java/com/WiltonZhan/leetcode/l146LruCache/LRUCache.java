package com.WiltonZhan.leetcode.l146LruCache;

import java.util.HashMap;
import java.util.Map;

/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。



进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？  ---> 用双向链表实现，链表头放最近被使用的，链表尾放最久未使用的。



示例:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node header;  // dummy head
    private final Node trailer;   // dummy trailer

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        size = 0;

        header = new Node();
        trailer = new Node();
        header.next = trailer;
        trailer.prev = header;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveToFirst(node);  // 最近被使用，移动到头部
        }
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        // 已存在，则只更新值和位置
        if (node != null) {
            node.value = value;
            moveToFirst(node);
            return;
        }

        // 不存在，则加入链表
        node = new Node(key, value);
        cache.put(key, node);
        if (size == capacity) {
            Node oldestNode = removeLast();
            cache.remove(oldestNode.key);
            addFirst(node);
        } else {
            addFirst(node);
            size++;
        }
    }

    private void addBetween(Node newNode, Node predecessor, Node successor) {
        predecessor.next = newNode;
        newNode.prev = predecessor;
        newNode.next = successor;
        successor.prev = newNode;
    }

    private void addFirst(Node newNode) {
        addBetween(newNode, header, header.next);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node .prev;
    }

    private void moveToFirst(Node node) {
        removeNode(node);
        addFirst(node);
    }

    private Node removeLast() {
        Node node = trailer.prev;
        removeNode(node);
        return node;
    }
}
