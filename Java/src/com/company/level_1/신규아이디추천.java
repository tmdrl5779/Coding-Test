package com.company.level_1;

public class 신규아이디추천 {

    public String solution(String new_id) {
        String answer = "";

        //case1
        new_id = new_id.toLowerCase();

        //case2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        //case3
        new_id = new_id.replaceAll("[.]+",".");
        //new_id = new_id.replaceAll("[.]{2,}", ".");

        //case4
        StringBuilder stringBuilder = new StringBuilder(new_id);
        if (stringBuilder.length() > 0) {
            if(stringBuilder.charAt(0) == '.') stringBuilder.deleteCharAt(0);
        }
        if (stringBuilder.length() > 0) {
            if(stringBuilder.charAt(stringBuilder.length()-1) == '.') stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        //case5
        if (stringBuilder.length() < 1) stringBuilder.append("a");

        //case6
        if (stringBuilder.length() > 15) {
            stringBuilder.delete(15, stringBuilder.length());
            if (stringBuilder.charAt(stringBuilder.length()-1) == '.'){
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }


        //case7
        if (stringBuilder.length() < 3) {
            while (stringBuilder.length() < 3){
                stringBuilder.append(stringBuilder.charAt(stringBuilder.length()-1));
            }
        }

        answer = new String(stringBuilder);

        return answer;
    }

}
