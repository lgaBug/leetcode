package com.lga.algorithm.tag.homework.Week_04;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class LadderLength {



    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (endWord.length() != beginWord.length() || !wordList.contains(endWord)) return  0;
        return bfs(beginWord, endWord, wordList);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int ans = 0;
        queue.add(beginWord);

        while (!queue.isEmpty()){
            int size = queue.size();
            //每一层加一
            ans++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) continue;
                    //判断是否满足转换
                    if (!convert(poll,wordList.get(j))) continue;
                    //如果当前元素已经是最后需要的元素，则返回
                    if (wordList.get(j).equals(endWord)) return ans + 1; //加以是因为要算上起始元素
                    visited[j] = true;
                    queue.add(wordList.get(j));
                }
            }
        }
        return 0;
    }

    private boolean convert(String poll, String s) {
        int diff = 0;
        int i = 0;
        while (i < poll.length()) {
            if (poll.charAt(i) != s.charAt(i++)) {
                if(++diff>1) return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

    }

}
