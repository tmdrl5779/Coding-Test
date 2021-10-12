package com.company.kakao2021;

import java.util.*;

public class Three {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        String[][] sa = new String[records.length][3];

        for(int i = 0; i < records.length; i++){
            String[] split = records[i].split(" ");
            sa[i] = split;

        }

        Map<String, List<String>> map = new TreeMap<>();

        for(int i = 0; i < sa.length; i++){
            String key = sa[i][1];
            String time = sa[i][0];

            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(time);
                map.put(key, list);
            }else{
                List<String> list = map.get(key);
                list.add(time);
            }
        }

        answer = new int[map.size()];

        int j = 0;
        for (String s : map.keySet()) {
            List<String> list = map.get(s);

            if(list.size() % 2 != 0) list.add("23:59");

            int sumTime = 0;
            for(int i = 0; i < list.size(); i += 2){
                String s1 = list.get(i);
                String s2 = list.get(i + 1);

                String[] split1 = s1.split(":");
                String[] split2 = s2.split(":");

                int time1 = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
                int time2 = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);

                sumTime += time2 - time1;
            }

            if(sumTime <= fees[0]){
                answer[j] = fees[1];
            }else{
                answer[j] = fees[1] + (int)Math.ceil((double) (sumTime - fees[0]) / (double)fees[2]) * fees[3];
            }

            j++;
        }

        return answer;
    }
}
