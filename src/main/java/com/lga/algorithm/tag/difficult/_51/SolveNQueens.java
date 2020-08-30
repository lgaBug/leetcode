package com.lga.algorithm.tag.difficult._51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {

    private int n;
    private List<List<String>> res;
    private List<String> board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append('.');
        for (int i = 0; i < n; ++i) board.add(sb.toString());
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (!isValid(row, col)) continue;
            setChar(row, col, 'Q');
            backtrack(row + 1);
            setChar(row, col, '.');
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (board.get(i).charAt(col)=='Q')
                return false;
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;--i,--j) {
            if (board.get(i).charAt(j)=='Q')
                return false;
        }
        for (int i=row-1,j=col+1;i>=0&&j<n;--i,++j) {
            if (board.get(i).charAt(j)=='Q')
                return false;
        }
        return true;
    }

    private void setChar(int row, int col, char c) {
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, c);
        board.set(row, sb.toString());
    }
}
