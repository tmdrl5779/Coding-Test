package com.company.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char sizer = (char)(c + n);
            if (Character.isUpperCase(c)){
                if (sizer > 'Z'){
                    answer += (char)(sizer - 'Z' + 64);
                }else{
                    answer += sizer;
                }
            }else if (Character.isLowerCase(c)){
                if (sizer > 'z'){
                    answer += (char)(sizer - 'z' + 96);
                }else{
                    answer += sizer;
                }
            }else{
                answer += c;
            }
        }
        return answer;
    }
}
