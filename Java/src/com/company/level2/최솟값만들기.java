package com.company.level2;

import java.util.*;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for(int i = 0; i < A.length; i++){
            a.add(A[i]);
            b.add(B[i]);
        }

        Collections.sort(a);
        Collections.sort(b);

        while(!a.isEmpty()){
            answer += a.get(a.size()-1) * b.get(0);
            a.remove(a.size()-1);
            b.remove(0);
        }

        return answer;
    }
}
