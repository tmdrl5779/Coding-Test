package com.company.monthChallenge;

import java.util.*;

public class Anti {
    long count = 0;
    public int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];

        int start = 0;

        for(int i = 0; i < s.length; i++){
            int[] sub = Arrays.copyOfRange(a, start, start+s[i]);
            start += s[i];
            Stack<Integer> c = new Stack<>();
            List<Map<Integer, Integer>> anti = new LinkedList<>();
            for(int j = 0; j< sub.length; j++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(j, sub[j]);
                anti.add(map);
            }
            recursive(sub, 0, c, anti);
            answer[i] = (int) (count % (long)(100000000 + 7));
            count = 0;
        }

        return answer;
    }


    public void recursive(int[] b, int i, Stack<Integer> c, List<Map<Integer, Integer>> anti){
        if(i == b.length){
            count++;
            return;
        }

        Map<Integer, Integer> x = new HashMap<>();

        int j = 0;
        for(Map map : anti){
            if(map.containsKey(i)){
                x = map;
                break;
            }
            j++;
        }

        if(j-1 >= 0){
            Map<Integer, Integer> y = anti.get(j-1);
            long xSum = 0;
            long ySum = 0;

            for(Integer num : x.values()){
                xSum += num;
            }

            for(Integer num : y.values()){
                ySum += num;
            }

            if(xSum == ySum) {
                Map<Integer, Integer> originX = new HashMap<>();
                originX.putAll(x);
                Map<Integer, Integer> originY = new HashMap<>();
                originY.putAll(y);

                y.putAll(x);
                anti.remove(j);
                c.push(i);
                recursive(b, i, c, anti);
                c.pop();

                anti.set(j - 1, originY);
                anti.add(j, originX);
//                recursive(b, i + 1, c, anti);

            }//else{
//                recursive(b, i+1, c, anti);
//            }

        }//else{
//            recursive(b, i+1, c, anti);
//        }
        recursive(b, i + 1, c, anti);

    }
}
