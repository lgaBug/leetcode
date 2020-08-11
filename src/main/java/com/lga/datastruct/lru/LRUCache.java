package com.lga.datastruct.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private final int capacity;
    private Map<K, V> map;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<K, V>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

}
