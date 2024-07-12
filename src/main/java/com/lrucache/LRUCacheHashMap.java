package com.lrucache;


import com.lrucache.models.BaseCacheItem;

import java.util.*;

public class LRUCacheHashMap<K, V extends BaseCacheItem<?>> extends AbstractLRUCache<K, V> {

    private final Deque<K> keysSequence;
    private final Map<K, V> cache;
    private final CacheLimits options;

    public LRUCacheHashMap(final CacheLimits options) {
        this.options = options;
        this.cache = new HashMap<>();
        this.keysSequence = new ArrayDeque<>(options.maxItemsCount());
    }

    private boolean isFull() {
        return keysSequence.size() == options.maxItemsCount();
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
        if (isFull() && !cache.containsKey(key)) {
            var removedKey = keysSequence.removeLast();
            cache.remove(removedKey);
        }

        if (cache.containsKey(key)) {
            keysSequence.remove(key);
        }

        keysSequence.addFirst(key);
        cache.put(key, value);
    }

    @Override
    protected List<K> getKeysByPriority() {
        return keysSequence.stream().toList();
    }

}
