package com.company.level2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = {};
        int zero = 0;
        int count = 0;

        while(true){
            if(s.equals("1")) break;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zero += 1;
                    continue;
                }
                sb.append(s.charAt(i));
            }

            int len = sb.length();
            sb.setLength(0);

            while(len > 0){
                int mod = len % 2;
                len = len / 2;
                sb.insert(0, String.valueOf(mod));

            }
            s = sb.toString();
            count += 1;
        }

        answer = new int[]{count, zero};

        return answer;
    }
}
