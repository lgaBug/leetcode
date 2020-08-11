package com.lga.datastruct.lru;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LRU 缓存策略的使用
 */
public class LinkHashMapTest {

    @Test
    public void test1() {

        Map<Integer, String> cache = new LinkedHashMap<Integer, String>(6,0.75f,true);

        cache.put(1, "liugaoan");
        cache.put(2, "wl");
        cache.put(3, "zs");
        cache.put(4, "ls");
        cache.put(5, "ww");
        cache.put(6, "zl");
        cache.put(7, "zl1");
        cache.get(3);

        Set<Map.Entry<Integer, String>> entries = cache.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }


    }

}
