package com.company.kakao2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Four {
    Stack<Integer> stack = new Stack<Integer>();

    List<int[]> pointCombination = new ArrayList<>();
    List<int[]> pointPermutation = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int appachSum = 0;
        int lionSum = 0;

        stack.push(n);



        List<int[]> list = new ArrayList<>();
        numberCombination(list);
        for(int i = 1; i < n+1; i++){
            combination(new boolean[11], 0, i, 0);
        }

        for(int i = 0; i < pointCombination.size(); i++){
            int length = pointCombination.get(i).length;

            for(int j = 0; j < list.size(); j++){
                int length1 = list.get(j).length;
                if(length == length1){
                    int k = 0;
                    permutation(new boolean[list.get(j).length], list.get(j), 0, new Stack<>());
                    for(int[] array : pointPermutation){ //순열 돌린거
                        int[] lion = new int[11];
                        for(int x = 0; x < length; x++){
                            lion[pointCombination.get(i)[x]] = array[x];
                        }

                        for(int y = 0; y < info.length; y++){
                            int appach = info[y];
                            int lio = lion[y];

                            if(appach > lio){
                                appachSum += (10-y);
                            }else if(appach < lio){
                                lionSum += (10-y);
                            }else{
                                appachSum += (10-y);
                            }
                        }

                        if(appachSum < lionSum){
                            return lion;
                        }


                        k++;
                    }
                    pointPermutation.clear();
                }
            }

        }


        return answer;
    }

    public void permutation(boolean[] visited, int[] array, int depth, Stack<Integer> temp){
        if(depth == array.length){
            int[] subtemp = new int[temp.size()];
            for(int i = 0; i < temp.size(); i++){
                subtemp[i] = temp.get(i);
            }
            pointPermutation.add(subtemp);

            return;
        }

        for(int i = 0; i < array.length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            temp.push(array[i]);
            permutation(visited, array, depth+1, temp);
            visited[i] = false;
            temp.pop();

        }

    }



    public void numberCombination(List<int[]> list) {
        while (true) {
            int[] stackToArray = new int[stack.size()];
            for(int i = 0; i < stack.size(); i++){
                stackToArray[i] = stack.get(i);
            }
            list.add(stackToArray);
            int temp = stack.pop();
            if (temp != 1) {
                stack.push(temp - 1);
                stack.push(1);
            } else {
                int sum = 2;
                for (; !stack.isEmpty() && stack.peek() == 1; stack.pop())
                    sum++;
                if (stack.isEmpty())
                    break;
                int pivot = stack.pop() - 1;
                stack.push(pivot);
                while (sum > pivot) {
                    stack.push(pivot);
                    sum -= pivot;
                }
                stack.push(sum);
            }
        }
    }

    public void combination(boolean[] visited, int depth, int n, int start){
        if(depth == n){
            int[] array = new int[n];
            int j = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) {
                    array[j] = i;
                    j++;
                }
            }

            pointCombination.add(array);
            return;
        }


        for(int i = start; i < visited.length; i++){
            visited[i] = true;
            combination(visited, depth+1, n, i+1);
            visited[i] = false;
        }

    }
}
