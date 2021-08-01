package com.lga.algorithm.tag.arrayandstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysQuestionTest {

    private ArraysQuestion arraysQuestion = new ArraysQuestion();

    @Test
    public void pivotIndex01() {

        int result = arraysQuestion.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        int expect = 3;
        assertEquals(expect, result);
    }

    @Test
    public void merge() {
        int[][] result = arraysQuestion.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] expect = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        assertEquals(expect, result);
    }

    @Test
    public void rotate() {
        int[][] expect = new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        int[][] input = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        arraysQuestion.rotate(input);
        assertEquals(expect,input);
    }
}