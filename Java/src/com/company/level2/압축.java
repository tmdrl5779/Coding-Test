package com.company.level2;

import java.util.*;

public class 압축 {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        char c = 'A';
        int idx = 26;

        for(int i = 0; i < 26; i++){
            map.put(String.valueOf(c), i+1);
            c = (char)(c + 1);
        }
        StringBuilder sb = new StringBuilder(msg);

        while(sb.length() > 0){
            StringBuilder w = new StringBuilder();
            StringBuilder prev = new StringBuilder();

            for(int i = 0; i < sb.length(); i++){
                w.append(sb.charAt(i));

                if(!map.containsKey(w.toString())){
                    idx++;
                    map.put(w.toString(), idx);
                    list.add(map.get(prev.toString()));
                    sb.delete(0, i);
                    break;
                }else{
                    prev = new StringBuilder(w.toString());
                }

                if(i == sb.length()-1){
                    list.add(map.get(prev.toString()));
                    sb.delete(0, sb.length());
                }


            }

        }

        return answer;
    }
}
