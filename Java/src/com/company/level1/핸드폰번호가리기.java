package com.company.level1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = phone_number;
        int num = phone_number.length()-4;

        for (int i = 0; i < num; i++){
            answer = answer.replaceFirst("[0-9]", "*");
        }

        return answer;
    }
}
