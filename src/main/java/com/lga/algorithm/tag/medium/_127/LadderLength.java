package com.lga.algorithm.tag.medium._127;

import org.junit.Test;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class LadderLength {

    //暴力法开始
    int min = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.length() != endWord.length()) return 0;
        backtrace(beginWord, endWord, wordList, 1, new HashSet<String>());
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void backtrace(String start, String end, List<String> wordList, int step, Set<String> set) {
        if (start.equals(end)) min = Math.min(min, step);
        for (String str : wordList) {
            if (set.contains(str)) continue;
            int count = 0;
            for (int j = 0; j < start.length(); j++) {
                if (start.charAt(j) != str.charAt(j))
                    if (++count > 1) break;
            }
            if (count == 1) {
                set.add(str);
                backtrace(str, end, wordList, step + 1, set);
                set.remove(str);
            }
        }
    }

    // 暴力法结束

    public int ladderLength_1(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        //记录已访问过的元素
        boolean[] isVisited = new boolean[wordList.size()];
        //广搜队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //深度
        int depth = 0;
        //广搜/层序遍历模板
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    //已经访问过的元素跳过,树中不存在重复节点
                    if (isVisited[j]) {
                        continue;
                    }
                    //孩子节点只能改变一个字符转换为s,不满足则跳过
                    if (!canConvert(poll, wordList.get(j))) {
                        continue;
                    }
                    //如果节点s等于endWord,接龙完成
                    if (wordList.get(j).equals(endWord)) {
                        return depth + 1;
                    }
                    isVisited[j] = true;
                    queue.add(wordList.get(j));
                }
            }
        }
        return 0;
    }

    //poll是否只可以改变一个字符转换为s
    private boolean canConvert(String poll, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (poll.charAt(i) != s.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }


    @Test
    public void test() {
        System.out.println(ladderLength_1("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));

    }
}
