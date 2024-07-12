package com.lrucache.models;

/**
 * An abstract class representing a basic cache item.
 * This class implements {@link CacheableAction} and provides default implementations
 * for the actions to be performed on read and write operations.
 *
 * @param <V> the type of the value held by this cache item
 */
public abstract class BaseCacheItem<V> implements CacheableAction {

    /**
     * The value held by this cache item.
     */
    protected V value;

    /**
     * Constructs a new {@code BaseCacheItem} with the specified value.
     *
     * @param value the value to be held by this cache item
     */
    public BaseCacheItem(V value) {
        this.value = value;
    }

    /**
     * This method is called when the cache item is read.
     * Default implementation does nothing.
     */
    @Override
    public void doOnRead() {}

    /**
     * This method is called when the cache item is written.
     * Default implementation does nothing.
     */
    @Override
    public void doOnWrite() {}

    /**
     * Returns a string representation of this cache item.
     *
     * @return a string representation of this cache item
     */
    @Override
    public String toString() {
        return "BaseCacheItem{" +
                "value=" + value +
                '}';
    }
}
