package com.company;

import java.util.Arrays;

public class 수분할 {

    public void solution(int n){

        int[] a = new int[n];

        dfs(a, n, n, 0);

    }

    public void dfs(int[]array, int remainder, int n, int index){
        if(remainder == 0){
            System.out.println(Arrays.toString(array));
            return;
        }

        for(int i = 1; i < n; i++){
            if(remainder - i < 0) continue;

            array[index] = i;
            dfs(array, remainder - i, n, index + 1);
            array[index] = 0;

        }

    }

}
