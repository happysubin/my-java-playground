package happysubin.javapractice.codingtest.programmers.level_three;

import java.util.*;
import java.util.stream.Collectors;

public class Hash {

    class Song{
        int index;
        int play;
        String genres;

        public Song(int index, int play, String genres) {
            this.index = index;
            this.play = play;
            this.genres = genres;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "index=" + index +
                    ", play=" + play +
                    ", genres='" + genres + '\'' +
                    '}';
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
            songMap.put(genres[i], songMap.getOrDefault(genres[i], new ArrayList()));
            List<Song> songs = songMap.get(genres[i]);
            songs.add(new Song(i, plays[i], genres[i]));
        }

        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        Set<String> set = songMap.keySet();
        for (String genre : set) {
            Collections.sort(songMap.get(genre), new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    if(o1.play == o2.play) return o2.index - o1.index;
                    else return o2.play - o1.play;
                }
            });
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int i = -1;

        for (Map.Entry<String, Integer> entry : collect) {
            List<Song> songs = songMap.get(entry.getKey());
            for (int j = 0; j < 2; j++) {
                if(songs.size() != 0){
                    temp.add(songs.remove(0).index);
                }
            }
        }

        int[] answer = new int[temp.size()];

        for (int j = 0; j < temp.size(); j++) {
            answer[j] = temp.get(j);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800,  2500};
        Hash main = new Hash();
        int[] solution = main.solution(genres, plays);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
