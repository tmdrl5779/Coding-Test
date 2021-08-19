package com.company.level1;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] countClothes = new int[n+2];

        for(int lostPeople : lost)
            countClothes[lostPeople]--;
        for(int reservePeople : reserve)
            countClothes[reservePeople]++;

        for(int count : countClothes){
            if(count == -1){
                answer--;
            }
        }

        for(int i = 0; i < n; i++){
            if(countClothes[i] == -1 && countClothes[i-1] == 1){
                answer++;
                countClothes[i]++;
                countClothes[i-1]--;
                continue;
            }
            if(countClothes[i] == -1 && countClothes[i+1] == 1){
                answer++;
                countClothes[i]++;
                countClothes[i+1]--;
                continue;
            }
        }

        return answer;
    }
}
