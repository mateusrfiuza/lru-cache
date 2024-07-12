package com.lrucache.models;

import java.time.LocalDateTime;

public final class DateCacheItem<V> extends BaseCacheItem<V> {

    private final LocalDateTime creationDate;
    private LocalDateTime lastAccessDate;

    public DateCacheItem(V value) {
       super(value);
       var newDate = LocalDateTime.now();
       this.creationDate = newDate;
       this.lastAccessDate = newDate;
    }

    @Override
    public void doOnRead() {
        this.lastAccessDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DateCacheItem{" +
                "creationDate=" + creationDate +
                ", lastAccessDate=" + lastAccessDate +
                ", value=" + value +
                '}';
    }

}
