package com.company.kakao2021;

public class Two {
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder convert = convert(n, k);
        convert = convert.reverse();

        for(int i = 0; i < convert.length(); i++){
            for(int j = i; j < convert.length()+1; j++){

                String substring = convert.substring(i, j);

                if(substring.equals("")) continue;
                if(substring.contains("0")) continue;

                boolean isSosu = isSosu(substring);
                if(!isSosu || Long.parseLong(substring) == 1 || Long.parseLong(substring) == 0) continue;

                int left = i - 1;
                int right = j;

                if(left == -1 && right == convert.length()){
                    answer++;
                    i = j-1;
                    break;
                }else if(left == -1){
                    if(convert.charAt(right) == '0'){
                        answer++;
                        i = j-1;
                        break;
                    }
                }else if(right == convert.length()){
                    if(convert.charAt(left) == '0'){
                        answer++;
                        i = j-1;
                        break;
                    }
                }else if(convert.charAt(left) == '0' && convert.charAt(right) == '0'){
                    answer++;
                    i = j-1;
                    break;
                }

            }
        }

        return answer;
    }

    public StringBuilder convert(int n, int k){
        StringBuilder sb = new StringBuilder();
        int c = n;

        while(c > 0){
            if(c % k < 10){
                sb.append(c % k);
            }else{
                sb.append((char) (c % k - 10 + 'A'));
            }
            c /= k;

        }
        return sb;
    }

    public boolean isSosu(String s){
        long n = Long.parseLong(s);
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
