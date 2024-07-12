package com.lrucache.models;

/**
 * An interface defining actions that can be performed on cache items.
 * Implementing classes will provide specific behavior for read and write operations.
 */
public interface CacheableAction {

    /**
     * This method is called when the cache item is read.
     * Implementing classes should define the specific behavior to be performed on read.
     */
    void doOnRead();

    /**
     * This method is called when the cache item is written.
     * Implementing classes should define the specific behavior to be performed on write.
     */
    void doOnWrite();
}
