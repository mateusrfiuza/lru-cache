package com.lrucache;

import com.lrucache.models.BaseCacheItem;

import java.util.Optional;

/**
 * THE Least Recently Used (LRU) cache is a type of cache that evicts the 'least recently used items'
 * when there is a need to constrain its size.
 * <p>
 * For this particular implementation, the size constraint is set at CacheLimits.maxItemsCount.
 * An item is considered accessed whenever `get`, or `set` methods are called with its key.
 * <p>
 * This LRU cache will achieve size constraint by checking the cache size at the time of each new insertion.
 * In the case where the cache has reached its limit, the item least recently accessed will be removed.
 * This removal process will not happen on a separate thread but in the caller's thread,
 * thus potentially blocking their return for a cleanup when deemed necessary.
 */
public interface LRUCache<K, V extends BaseCacheItem<?>> {

    void set(K key, V value);

    Optional<V> get(K key);

    void print();

}
