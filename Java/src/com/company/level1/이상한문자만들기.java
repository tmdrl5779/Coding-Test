package com.company.level1;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";

        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                if (count%2 == 0){
                    answer += Character.toUpperCase(s.charAt(i));
                }else{
                    answer += Character.toLowerCase(s.charAt(i));
                }
                count++;
            }else{
                answer += ' ';
                count = 0;
            }
        }
        return answer;
    }
}
