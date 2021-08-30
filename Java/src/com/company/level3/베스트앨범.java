package com.company.level3;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Data> hashMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){

            Song song = new Song();
            song.index = i;
            song.playCount = plays[i];

            if(!hashMap.containsKey(genres[i])){
                Data data = new Data();
                data.sum = plays[i];
                data.list.add(song);

                hashMap.put(genres[i], data);
            }else{
                Data data = hashMap.get(genres[i]);
                data.sum += plays[i];
                data.list.add(song);
                Collections.sort(data.list, (o1, o2) -> {
                    return Integer.compare(o2.playCount, o1.playCount);
                });
            }
        }

        List<Map.Entry<String,Data>> list = new ArrayList<>(hashMap.entrySet());


        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o2.getValue().sum, o1.getValue().sum);
        });


        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getValue().list.size() > 1){
                answer.add(list.get(i).getValue().list.get(0).index);
                answer.add(list.get(i).getValue().list.get(1).index);
            } else{
                answer.add(list.get(i).getValue().list.get(0).index);
            }
        }

        int[] answer2 = new int[answer.size()];

        for(int i = 0; i < answer.size(); i++){
            answer2[i] = answer.get(i);
        }

        return answer2;
    }

    private class Data{
        List<Song> list = new ArrayList<>();
        int sum;
    }

    private class Song{
        int index;
        int playCount;
    }
}
