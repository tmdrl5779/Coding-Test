package com.company.level2;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < bridge_length - 1; i++){
            queue.add(0);
        }

        queue.add(truck_weights[0]);
        totalWeight += truck_weights[0];
        answer++;

        int truckCount = 1;
        int i = 1;

        if(truck_weights.length == 1){
           answer += bridge_length;
        }

        while(truck_weights.length > 1){
            int remove = queue.remove();
            if(remove != 0){
                truckCount --;
            }
            totalWeight -= remove;
            answer += 1;


            if(totalWeight + truck_weights[i] > weight){
                if (truckCount < bridge_length) {
                    queue.add(0);
                }
            }else{
                if (truckCount < bridge_length) {
                    queue.add(truck_weights[i]);
                    totalWeight += truck_weights[i];
                    truckCount++;
                    i++;
                }
            }

            if(i == truck_weights.length){
                answer += bridge_length;
                break;
            }

        }


        return answer;
    }
}
