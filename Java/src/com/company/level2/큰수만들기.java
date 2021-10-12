package com.company.level2;

public class 큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int n = number.length() - k;
        int end = -1;
        for(int i = 0; i < number.length() - k; i++){
            int max = 0;
            int maxIdx = number.length() - n;

            for(int j = end+1; j < number.length() - n + 1; j++){
                int now = Integer.parseInt(String.valueOf(number.charAt(j)));
                if(now == 9){
                    max = 9;
                    maxIdx = j;
                    break;
                }

                if(max < now){
                    max = now;
                    maxIdx = j;
                }
            }

            end = maxIdx;
            sb.append(max);
            n--;
        }

        answer = sb.toString();
        return answer;
    }

}
