package com.WiltonZhan.leetcode.l146LruCache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void lruCacheTest() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        assertEquals(3, cache.get(3));       // 返回  3
        assertEquals(4, cache.get(4));       // 返回  4
    }

}