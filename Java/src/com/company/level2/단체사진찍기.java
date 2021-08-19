package com.company.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 단체사진찍기 {
    int count = 0;

    public int solution(int n, String[] data) {
        int answer = 0;
        String[] user = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[user.length];
        Stack<String> stack = new Stack<>();
        dfs(user, visited, data, 0, stack);
        answer = count;
        return answer;
    }

    public void dfs(String[] graph, boolean[] visited, String[] data, int depth, Stack<String> stack) {
        if (depth == graph.length) {
            boolean check = false;
            for (int i = 0; i < data.length; i++) {
                String s = data[i];
                String user1 = String.valueOf(s.charAt(0));
                String user2 = String.valueOf(s.charAt(2));

                int index1 = stack.indexOf(user1);
                int index2 = stack.indexOf(user2);

                int dist = Math.abs(index1 - index2) - 1;
                int num = Integer.parseInt(String.valueOf(s.charAt(4)));

                if (s.charAt(3) == '='){
                    if (dist == num) check = true;
                    else check = false;
                } else if (s.charAt(3) == '<'){
                    if (dist < num) check = true;
                    else check = false;
                } else{
                    if (dist > num) check = true;
                    else check = false;
                }

                if (!check) break;
            }
            if (check) count ++;
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            stack.push(graph[i]);
            dfs(graph, visited, data, depth + 1, stack);
            stack.pop();
            visited[i] = false;
        }

    }
}
