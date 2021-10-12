package com.company.line20201;

import java.util.*;

public class Six {
    public String[] solution(String[] records, int k, String date) {
        String[] answer = {};
        String[][] sArray = new String[records.length][3];
        String[] end = date.split("-");
        String startDate = date.replaceAll("-", "");
        String endDate = "";

        for(int i = 0; i< k; i++){
            end[2] = String.valueOf(Integer.parseInt(end[2]) - 1);
            if(end[2].equals("-1")){
                end[2] = "30";
                end[1] = String.valueOf(Integer.parseInt(end[1]) - 1);
            }
        }

        if(end[1].length() == 1){
            end[1] = "0" + end[1];
        }
        if(end[2].length() == 1){
            end[2] = "0" + end[2];
        }

        endDate = end[0] + end[1] + end[2];

        for(int i = 0; i < records.length; i++){
            sArray[i] = records[i].split(" ");
            sArray[i][0] = sArray[i][0].replaceAll("-", "");
        }

        Arrays.sort(sArray, (o1, o2) -> {
            int into1 = Integer.parseInt(o1[0]);
            int into2 = Integer.parseInt(o2[0]);
            return Integer.compare(into1, into2);
        });

        int startIdx = 0;
        int endIdx = sArray.length-1;

        for(int i = 0; i < sArray.length; i++){
            if(sArray[i][0].equals(endDate)){
                startIdx = i;
                break;
            }
        }

        for(int j = sArray.length-1; j > -1; j--){
            if(sArray[j][0].equals(startDate)){
                endIdx = j;
                break;
            }
        }

        Map<String, double[]> map = new HashMap<>(); //상품이름 , [재구매율, 총개수]
        Map<String, List<String>> map2 = new HashMap<>(); //상품이름, 사람이름
        for(int i = startIdx; i < endIdx+1; i++){
            if(!map2.containsKey(sArray[i][2])){
                List<String> list = new ArrayList<>();
                list.add(sArray[i][1]);
                map2.put(sArray[i][2], list);
            }else{
                List<String> list = map2.get(sArray[i][2]);
                list.add(sArray[i][1]);
            }

        }

        for(String key : map2.keySet()){
            Map<String, Integer> map3 = new HashMap<>(); //사람이름, 상품개수
            List<String> list = map2.get(key);
            for(String s : list){
                if(!map3.containsKey(s)){
                    map3.put(s, 1);
                }else{
                    map3.replace(s, map3.get(s) + 1);
                }
            }

            int jae = 0; //재구매 한사람 수
            int chong = map3.size(); //총 사람

            for(String key3 : map3.keySet()){
                if(map3.get(key3) > 1){
                    jae++;
                }
            }

            double yul = (jae / (double)chong) * 100;
            map.put(key, new double[]{yul , map2.get(key).size()});
        }

        List<Map.Entry<String, double[]>> entries = new ArrayList<Map.Entry<String, double[]>>(map.entrySet());

        Collections.sort(entries, (o1, o2) -> {
            if(o1.getValue()[0] > o2.getValue()[0]){
                return -1;
            }else if(o1.getValue()[0] < o2.getValue()[0]){
                return 1;
            }else{
                return Double.compare(o2.getValue()[1], o1.getValue()[1]);
            }
        });
        answer = new String[entries.size()];
        int x = 0;
        for (Map.Entry<String, double[]> entry : entries) {
            answer[x] = entry.getKey();
             x++;
        }


        return answer;


    }
}
