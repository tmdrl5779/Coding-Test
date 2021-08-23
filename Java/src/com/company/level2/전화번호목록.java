package com.company.level2;
import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> hashMap = new HashMap<>();

        for(String phone : phone_book){
            hashMap.put(phone, 1);
        }

        for(int i = 0; i < phone_book.length; i++){
            String phone = phone_book[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < phone.length(); j++){
                sb.append(phone.charAt(j));
                if (sb.toString().equals(phone)){
                    continue;
                }
                if (hashMap.containsKey(sb.toString())){
                    return false;
                }
            }
        }

        return answer;
    }
}
