package com.company.level2;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution1(String[] record) {
        String[] answer = {};
        List<StringBuilder[]> list = new ArrayList<>();
        Map<String, StringBuilder> hashMap = new HashMap<>();

        for (int i = 0; i < record.length; i++){
            String[] s = record[i].split(" ");

            if ("Enter".equals(s[0])){
                StringBuilder sb = new StringBuilder(s[2]);
                StringBuilder enter = new StringBuilder("님이 들어왔습니다.");
                if(!hashMap.containsKey(s[1])){
                    hashMap.put(s[1], sb);
                    list.add(new StringBuilder[]{hashMap.get(s[1]), enter});
                }else{
                    hashMap.get(s[1]).replace(0, hashMap.get(s[1]).length(), s[2]);
                    list.add(new StringBuilder[]{hashMap.get(s[1]), enter});
                }

            } else if("Leave".equals(s[0])){
                StringBuilder leave = new StringBuilder("님이 나갔습니다.");
                list.add(new StringBuilder[]{hashMap.get(s[1]),  leave});

            } else{
                hashMap.get(s[1]).replace(0, hashMap.get(s[1]).length(), s[2]);
            }

        }
        answer = new String[list.size()];
        int i = 0;
        for (StringBuilder[] sb : list){
            answer[i] = sb[0].toString() + sb[1].toString();
            i++;
        }

        return answer;
    }

    public String[] solution2(String[] record){
        String[] answer = {};

        Map<String, User> hashMap = new HashMap<>();
        List<StringBuilder[]> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++){
            String[] s = record[i].split(" ");
            String command = s[0];
            String uid = s[1];
            if ("Enter".equals(command)){
                StringBuilder userName = new StringBuilder(s[2]);
                User user = new User(userName);
                StringBuilder enter = new StringBuilder("님이 들어왔습니다.");
                if (!hashMap.containsKey(uid)){
                    hashMap.put(uid, user);
                    list.add(new StringBuilder[]{hashMap.get(uid).userName, enter});
                } else{
                    hashMap.get(uid).userName.replace(0, hashMap.get(uid).userName.length(), userName.toString());
                    list.add(new StringBuilder[]{hashMap.get(uid).userName, enter});
                }
            } else if("Leave".equals(command)){
                StringBuilder leave = new StringBuilder("님이 나갔습니다.");
                list.add(new StringBuilder[]{hashMap.get(uid).userName, leave});
            } else{
                StringBuilder userName = new StringBuilder(s[2]);
                hashMap.get(uid).userName.replace(0, hashMap.get(uid).userName.length(), userName.toString());
            }
        }
        answer = new String[list.size()];
        int i = 0;
        for (StringBuilder[] sb : list){
            answer[i] = sb[0].toString() + sb[1].toString();
            i++;
        }

        return answer;
    }

    private class User{
        public StringBuilder userName;

        public User(StringBuilder userName) {
            this.userName = userName;
        }
    }
}
