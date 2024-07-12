package com.lrucache;

import com.lrucache.models.BaseCacheItem;

import java.util.*;

public class LRUCacheLinkedList<K, V extends BaseCacheItem<?>> extends AbstractLRUCache<K, V> {

    private final CacheLimits options;
    private final LinkedHashMap<K, V> cache;

    public LRUCacheLinkedList(final CacheLimits options) {
        this.options = options;
        this.cache = new LinkedHashMap<>(options.maxItemsCount(), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheLinkedList.this.options.maxItemsCount();
            }
        };
    }

    @Override
    public Integer size() {
        return cache.size();
    }

    @Override
    protected V getValue(K key) {
        return cache.get(key);
    }

    @Override
    protected void setValue(K key, V value) {
        cache.put(key, value);
    }

    @Override
    protected List<K> getKeysByPriority() {
        return new ArrayList<>(cache.keySet()).reversed();
    }

}
