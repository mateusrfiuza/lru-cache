package com.lrucache;

import com.lrucache.models.DefaultCacheItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheLinkedListTest {

    private LRUCacheLinkedList<Integer, DefaultCacheItem<?>> lruCache;

    @BeforeEach
    void setUp() {
        CacheLimits options = new CacheLimits(3);
        lruCache = new LRUCacheLinkedList<>(options);
    }

    @Test
    void setAndGetTest() {
        var item1 = new DefaultCacheItem<>("Value 1");
        var item2 = new DefaultCacheItem<>("Value 2");

        lruCache.set(1, item1);
        lruCache.set(2, item2);

        assertEquals(item1, lruCache.get(1).orElse(null));
        assertEquals(item2, lruCache.get(2).orElse(null));
    }

    @Test
    void evictionTest() {
        var item1 = new DefaultCacheItem<>("Value 1");
        var item2 = new DefaultCacheItem<>("Value 2");
        var item3 = new DefaultCacheItem<>("Value 3");

        lruCache.set(1, item1);
        lruCache.set(2, item2);
        lruCache.set(3, item3);

        var item4 = new DefaultCacheItem<>("Value 4");
        lruCache.set(4, item4);

        assertNull(lruCache.get(1).orElse(null));
        assertNotNull(lruCache.get(2).orElse(null));
    }

}