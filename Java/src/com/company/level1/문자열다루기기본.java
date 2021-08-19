package com.company.level1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = false;

//         try{
//             int a = Integer.parseInt(s);
//             if(s.length() == 4 || s.length() == 6){
//                 answer = true;
//             }

//         }catch(Exception e){
//             answer = false;
//         }

        if (s.length() == 4 || s.length() == 6){
            s = s.replaceAll("[0-9]", "");
            if (s.length() == 0){
                answer = true;
            }
        }

        return answer;
    }
}
