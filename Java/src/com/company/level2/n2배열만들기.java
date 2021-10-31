package com.company.level2;

public class n2배열만들기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];


        long leftRow = left / n;
        long leftCol = left - (n * leftRow);

        long rightRow = right / n;
        long rightCol = right - (n * rightRow);


        if(leftRow != rightRow){
            int idx = 0;
            idx = fuc((int)leftCol, n, idx, answer, (int)leftRow);

            for(int i = 0; i < rightRow - leftRow -1; i++){
                int row = (int)leftRow+i+1;
                idx = fuc(0, n, idx, answer, row);
            }
            idx = fuc(0, (int)rightCol+1, idx, answer, (int)rightRow);

        }else{
            int idx = 0;
            idx = fuc((int)leftCol, (int)rightCol+1, idx, answer, (int)leftRow);

        }


        return answer;
    }

    public int fuc(int start, int end, int idx, int[] answer, int row){
        for(int i = start; i < end; i++){
            if(i < row+1){
                answer[idx] = row+1;
            }else{
                answer[idx] = i + 1;
            }
            idx++;
        }
        return idx;
    }
}
