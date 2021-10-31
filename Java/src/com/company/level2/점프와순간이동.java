package com.company.level2;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 1;
        int divCount = 0;
        while(true){
            if(n <= 2) break;

            if(n%2 != 0) {
                n = n - 1;
                divCount += 1;
            }else {
                n = n / 2;
            }

        }

//         int[] dp = new int[n+1];
//         dp[1] = 1;


//         for(int i = 1; i < dp.length; i++){
//             if(i%2 == 0){ //짝수
//                 dp[i] = dp[i/2];
//             }else{ //홀수
//                 dp[i] = dp[i-1] + 1;
//             }
//         }

//         ans = dp[dp.length-1];
        ans = 1 + divCount;
        return ans;
    }
}
