package com.lga.algorithm.tag.arrayandstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringQuestionTest {


    private StringQuestion stringQuestion = new StringQuestion();

    @Test
    public void longestCommonPrefix() {
    }

    @Test
    public void longestPalindrome() {


        String result = stringQuestion.longestPalindrome01("babad");
        String expected = "bab";
        assertEquals(result, expected);

    }
}