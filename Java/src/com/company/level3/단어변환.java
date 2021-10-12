package com.company.level3;

public class 단어변환 {
    int globalAnswer = 1000;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        dfs(begin, target, words, new boolean[words.length], 0);
        answer = globalAnswer;
        if(answer == 1000) answer = 0;
        return answer;
    }

    public void dfs(String begin, String target, String[] words, boolean[] visited, int depth){
        if(begin.equals(target)){
            globalAnswer = Math.min(globalAnswer, depth);
            return;
        }
        if(depth == words.length){
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;

            String s = words[i];
            String temp = begin;
            int different = 0;
            for(int j = 0; j < s.length(); j++){
                if(begin.charAt(j) != s.charAt(j)){
                    different += 1;
                }
            }

            if(different != 1) continue;

            begin = s;
            visited[i] = true;
            dfs(begin, target, words, visited, depth+1);
            visited[i] = false;
            begin = temp;
        }
    }
}
