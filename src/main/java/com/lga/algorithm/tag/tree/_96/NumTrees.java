package com.lga.algorithm.tag.tree._96;

public class NumTrees {


    private int[][] cache;

    /**
     * 96. 不同的二叉搜索树
     * @param n
     * @return
     */
    public int numTrees(int n) {
        cache = new int[n+1][n+1];
        return count(1,n);
    }

    private int count(int l,int r){

        if(l > r) return 1;
        if(cache[l][r] != 0) return cache[l][r];
        int res = 0;
        for(int i =l;i<=r;i++){

            int left = count(l,i-1);
            int right = count(i+1,r);
            res +=left*right;
            cache[l][r] = res;
        }

        return res;
    }
}
