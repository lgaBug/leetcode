package com.lga;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

public class CountWordTest {
//
//
//    public static void main(String[] args) {
//
//
//        CountWordTest countWordTest = new CountWordTest();
//        try {
//            Map<String, Integer> count = countWordTest.count("/Users/liuga/github/leetcode/src/main/java/com/lga/test.txt");
//
//            System.out.println("count = " + count);
//
//
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public Map<String, Integer> count(String filePath) throws ExecutionException, InterruptedException {
//
//        // 多线程个数
//        int threadCount = 1;
//        //使用多线程，提高统计效率
//        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
//
//        File file = new File(filePath);
//        long fileSize = file.length();
//        long chunkSize = fileSize / threadCount;
//        int position = 0;
//
////        List<Future<Map<String ,Integer>>> futures = new LinkedList();
//
//        Map<String, Integer> result = new HashMap<>();
//
//
//        for (int i = 1; i <= threadCount; i++) {
//            long start = position;
//            long end;
//            if (i != threadCount) {
//                end = start + chunkSize;
//            } else {
//                //最后一个位置
//                end = fileSize;
//            }
//
//            Future<Map<String ,Integer>> submit = executorService.submit(new CountTask(filePath, start, end));
//            futures.add(submit);
//            //更新起始位置
//            position += chunkSize;
//        }
//
//        //汇总统计的返回结果，
//        for (int i = 0; i < threadCount; i++) {
//            Future<Map<String ,Integer>> future = futures.get(i);
//            Map<String, Integer> wordCountMap = future.get();
//            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
//                String word = entry.getKey();
//                Integer count = entry.getValue();
//                result.put(word, result.getOrDefault(word, 0) + count);
//            }
//        }
//
//        executorService.shutdown();
//        return result;
//    }
//
//    class CountTask implements Callable {
//
//        private String filePath;
//        private Long start;
//        private Long end;
//
//        public CountTask(String filePath, Long start, Long end) {
//            this.filePath = filePath;
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public Map<String, Integer> call() throws Exception {
//
//            //可以先给一个大小，方式后续扩容
//            Map<String, Integer> map = new HashMap<>();
//
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//            //跳过前面的位置
//            bufferedReader.skip(start);
//            String line = bufferedReader.readLine().toLowerCase(Locale.ROOT);
//
//            while (line.length() > 0) {
//                //通过空格进行切分
//                String[] words = line.replaceAll(",","").replaceAll("\\?","").split( "\\s+");
//                for (String word : words) {
//                    map.put(word, map.getOrDefault(word, 0) + 1);
//                }
//                line = bufferedReader.readLine().toLowerCase(Locale.ROOT);
//            }
//            return map;
//        }
//    }


}
