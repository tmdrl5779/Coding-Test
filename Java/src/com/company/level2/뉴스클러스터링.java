package com.company.level2;

import java.util.*;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        for (int i = 0; i < str1.length()-1; i++){
            String temp1 = str1.substring(i, i+2);

            if (temp1.matches("[a-z]{2,2}")){
                if (str1Map.containsKey(temp1)){
                    str1Map.replace(temp1, str1Map.get(temp1)+1);
                } else{
                    str1Map.put(temp1, 1);
                }
            }
        }

        for (int i = 0; i < str2.length()-1; i++){
            String temp2 = str2.substring(i, i+2);

            if (temp2.matches("[a-z]{2,2}")){
                if (str2Map.containsKey(temp2)){
                    str2Map.replace(temp2, str2Map.get(temp2)+1);
                } else{
                    str2Map.put(temp2, 1);
                }
            }
        }

        double gyo = 0;
        double hap = 0;
        // 1:2, 2:2, 3:1   1:1, 2:2, 4:1, 5:1
        for (String key : str1Map.keySet()){
            if (str2Map.containsKey(key)){
                gyo += Math.min(str1Map.get(key), str2Map.get(key));
                hap += Math.max(str1Map.get(key), str2Map.get(key));
                str2Map.replace(key, 0);
            } else{
                hap += str1Map.get(key);
            }
            str1Map.replace(key, 0);
        }
        for (String key : str2Map.keySet()){
            hap += str2Map.get(key);
        }

        if (gyo == 0 && hap == 0){
            answer = 65536;
        } else{
            double div = gyo / hap * 65536;
            answer = (int)div;
        }
        return answer;
    }
}
