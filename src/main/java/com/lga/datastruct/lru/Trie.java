package com.lga.datastruct.lru;

import org.junit.Test;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private boolean isEnd = false;
    private Trie[] next = new Trie[26];

    public Trie() {
    }

    public void insert(String word) {//插入单词
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
            root = root.next[w[i] - 'a'];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {//查找单词
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) return false;
            root = root.next[w[i] - 'a'];
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {//查找前缀
        Trie root = this;
        char[] p = prefix.toCharArray();
        for (int i = 0; i < p.length; ++i) {
            if (root.next[p[i] - 'a'] == null) return false;
            root = root.next[p[i] - 'a'];
        }
        return true;
    }

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("abc");
        boolean param_2 = trie.search("abc");
        boolean param_3 = trie.startsWith("ab");
        System.out.println("param_2 = " + param_2);
        System.out.println("param_3 = " + param_3);
    }
}
