package com.company.level1;

public class _1차비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int value = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();

            while (value > 0) {
                if (value % 2 == 0) {
                    sb.insert(0, " ");
                } else {
                    sb.insert(0, "#");
                }
                value /= 2;
            }
            int sbLength = sb.length();
            for (int j = 0; j < n - sbLength; j++) {
                sb.insert(0, " ");
            }
            answer[i] = sb.toString();

        }
        return answer;
    }
}
