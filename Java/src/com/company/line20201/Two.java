package com.company.line20201;

import java.util.*;

public class Two {
    public String solution(String[] research, int n, int k) {
        String answer = "";

        Map<Character, int[]> map = new TreeMap<>();
        Map<Character, Integer> set = new TreeMap<>();

        for(int i = 0; i < research.length; i++){
            for(int j = 0; j < research[i].length(); j++){
                char c = research[i].charAt(j);
                if(!map.containsKey(c)) {
                    int[] array = new int[research.length];
                    array[i] = 1;
                    map.put(c, array);
                }else{
                    int[] getArray = map.get(c);
                    getArray[i] += 1;
                }
            }
        }

        for(char c : map.keySet()){
            int[] getArray = map.get(c);

            for(int i = 0; i < getArray.length; i++){
                boolean isUp = false;
                int sum = 0;
                for(int j = i; j < n+i; j++){
                    if(j >= getArray.length) break;

                    if(getArray[j] < k) {
                        isUp = false;
                        break;
                    }
                    sum += getArray[j];
                    isUp = true;
                }

                if(isUp){
                    if(sum >= 2 * n * k){
                        if(!set.containsKey(c)){
                            set.put(c, 1);
                        }else{
                            set.replace(c, set.get(c) + 1);
                        }
                    }
                }
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(set.entrySet());

        Collections.sort(list, (o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });

        if(!list.isEmpty()){
            answer = list.get(0).getKey().toString();
        }else{
            answer = "None";
        }

        return answer;
    }
}
