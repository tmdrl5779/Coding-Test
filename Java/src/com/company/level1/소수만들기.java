package com.company.level1;

public class 소수만들기 {
    public int solution(int[] nums) {
        int[] answer = {0};

        dfs(nums, new boolean[nums.length], 0, answer, 0);

        return answer[0];
    }

    public void dfs(int[] nums, boolean[] visited, int depth, int[] answer, int iter) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += nums[i];
                }
            }
            boolean sosu = true;
            for (int i = 2; i < sum; i++) {
                if (sum % i == 0) {
                    sosu = false;
                    break;
                }
            }
            if (sosu) answer[0]++;
            return;
        }

        for (int i = iter; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(nums, visited, depth + 1, answer, i);
            visited[i] = false;
        }
    }
}
