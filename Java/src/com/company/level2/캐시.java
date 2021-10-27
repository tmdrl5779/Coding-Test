package com.company.level2;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new LinkedList<>();

        for(int i = 0; i < cities.length; i++){
            String s = cities[i].toLowerCase();

            if(cacheSize == 0){
                answer += 5;
            }else{
                if(list.size() == 0) {
                    list.add(s);
                    answer += 5;
                }else{
                    if(list.contains(s)){
                        list.remove(list.indexOf(s));
                        list.add(s);
                        answer += 1;
                    }else{
                        if(list.size() == cacheSize){
                            list.remove(0);
                        }
                        list.add(s);
                        answer += 5;
                    }

                }
            }


        }

        return answer;
    }
}
