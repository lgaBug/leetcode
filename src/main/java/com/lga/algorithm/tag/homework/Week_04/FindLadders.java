package com.lga.algorithm.tag.homework.Week_04;

import org.junit.Test;

import java.util.*;

/**
 * 126. 单词接龙 II
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 */
public class FindLadders {

    List<List<String>> ans = new LinkedList<>();
    int minSetp = Integer.MAX_VALUE;
    public List<List<String>> findLadders_backtance(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length() || !wordList.contains(endWord)) return ans;
        LinkedList<String> trace = new LinkedList<>();
        trace.add(beginWord);
        int setp = 1;
        backtrace(beginWord,endWord,wordList,trace,setp);
        return ans;
    }

    /**
     * 回溯算法
     * @param beginWord
     * @param endWord
     * @param wordList
     * @param trace
     */
    private void backtrace(String beginWord, String endWord, List<String> wordList, LinkedList<String> trace,int step) {
        if (trace.getLast().equals(endWord) && step <= minSetp) {
            //之前的最小个数
            int tempStep = minSetp;
            //之后的最小个数
            minSetp = Math.min(minSetp, step);
            //移除之前的最小个数的元素
            if (minSetp < tempStep) {
                Iterator<List<String>> iterator = ans.iterator();
                while (iterator.hasNext()) {
                    List<String> list = iterator.next();
                    if (list.size() == tempStep) iterator.remove();
                }
            }
            ans.add(new LinkedList<>(trace));
            return;
        }
        for (String str : wordList) {
            if (trace.contains(str)) continue;
            if (!convert(str,beginWord)) continue;
            trace.add(str);
            step++;
            backtrace(str,endWord,wordList,trace,step);
            trace.removeLast();
            step--;
        }

    }

    private boolean convert(String str, String beginWord) {
        int diff = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != beginWord.charAt(i))
                if(++diff>1) return false;
        }
        return true;
    }

    /**
     * 层次遍历
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length() || !wordList.contains(endWord)) return ans;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);
        LinkedList<String> list = new LinkedList<>();
        //key:子节点， value：父节点
        Map<String, String> parentMap = new HashMap<>();
        parentMap.put(beginWord, "NONE");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                list.add(poll);
                if (endWord.equals(poll)) {
                    ans.add(new LinkedList<>(list));
                }
                for (String str : wordList) {
                    if (visitedSet.contains(str)) continue;
                    if (!convert(poll,str))  continue;
                    queue.add(str);
                    visitedSet.add(str);
                    parentMap.put(str, poll);
                }
            }
//            if (completed) return ans;
        }

        while (!"NONE".equals(parentMap.get(endWord))) {
            System.out.print(endWord+"<-");
            endWord = parentMap.get(endWord);
        }
        return ans;
    }


    @Test
    public void test() {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
