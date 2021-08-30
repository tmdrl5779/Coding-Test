package com.company.level2;

import java.util.*;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        String[] lan = {"cpp", "java", "python", "-"};
        String[] skill = {"backend", "frontend", "-"};
        String[] career = {"junior", "senior", "-"};
        String[] food = {"chicken", "pizza", "-"};

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    for(int r = 0; r < 3;r ++){
                        map.put(lan[i]+skill[j]+career[k]+food[r], new ArrayList<>());
                    }
                }
            }
        }

        for(String i : info){
            Stack<String> stack = new Stack<>();
            List<String> list = new ArrayList<>();
            String[] ia = i.split(" ");
            dfs(0, ia, stack, list);

            for(int j = 0; j < list.size(); j++){
                map.get(list.get(j)).add(Integer.parseInt(ia[4]));
            }
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }



        int i = 0;
        for (String q : query){
            String[] qa = q.split(" ");
            String s = qa[0] + qa[2] + qa[4] + qa[6];
            int point = Integer.parseInt(qa[7]);
            List<Integer> list = map.get(s);

            int left = 0;
            int right = list.size()-1;
            int start = 0;
            while(left <= right){
                int mid = (left + right) / 2;

                if(point <= list.get(mid))
                    right = mid-1;
                else
                    left = mid + 1;

            }


            answer[i] = list.size() - left;

            i++;
        }

        return answer;
    }

    public void dfs(int depth, String[] sa, Stack<String> stack, List<String> results){
        if(depth == sa.length-1){
            String result = "";
            for(String s : stack){
                result += s;
            }
            results.add(result);
            return;
        }

        String[] temp = {sa[depth], "-"};

        for(int i = 0; i < 2; i++){
            stack.add(temp[i]);
            dfs(depth+1, sa, stack, results);
            stack.pop();
        }

    }

}
