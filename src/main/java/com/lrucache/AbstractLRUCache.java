package com.lrucache;

import com.lrucache.models.BaseCacheItem;
import com.lrucache.models.CacheableAction;

import java.util.List;
import java.util.Optional;

/**
 * A base class for implementing a cache with common behaviors for cache items.
 * This class provides default implementations for `get`, `set`, and `print` methods,
 * and requires subclasses to implement specific methods for getting and setting values,
 * and managing keys by priority.
 *
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of cached values, extending BaseCacheItem
 */
public abstract class AbstractLRUCache<K, V extends BaseCacheItem<?>> implements LRUCache<K, V> {

    /**
     * Retrieves the value associated with the specified key from the cache.
     * If the value is present, the {@link CacheableAction#doOnRead()} method is called.
     *
     * @param key the key whose associated value is to be returned
     * @return an {@link Optional} containing the value if present, otherwise an empty {@link Optional}
     */
    @Override
    public final Optional<V> get(K key) {
        return Optional.ofNullable(getValue(key))
                .map(value -> {
                    value.doOnRead();
                    return value;
                });
    }

    /**
     * Associates the specified value with the specified key in the cache.
     * Calls the {@link CacheableAction#doOnWrite()} method after setting the value.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    @Override
    public final void set(K key, V value) {
        setValue(key, value);
        value.doOnWrite();
    }

    /**
     * Prints all the key-value pairs in the cache, ordered by priority.
     * The format of each printed line is "Item: key - value".
     */
    @Override
    public void print() {
        final var keys = getKeysByPriority();
        keys.forEach(key -> {
            var value = getValue(key);
            System.out.println("Item: " + key + " - " + value);
        });
    }

    /**
     * @return the current cache size
     */
    public abstract Integer size();

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the cache contains no mapping for the key
     */
    protected abstract V getValue(K key);

    /**
     * Associates the specified value with the specified key.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    protected abstract void setValue(K key, V value);

    /**
     * Returns a list of keys ordered by priority.
     *
     * @return a list of keys ordered by priority
     */
    protected abstract List<K> getKeysByPriority();
}
