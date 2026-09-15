import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> manySongs = new HashMap<>();
        Map<String, List<int[]>> pergenres = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            manySongs.put(
                genres[i],
                manySongs.getOrDefault(genres[i], 0) + plays[i]
            );

            pergenres.putIfAbsent(genres[i], new ArrayList<>());
            pergenres.get(genres[i]).add(
                new int[]{i, plays[i]}
            );
        }


        List<Map.Entry<String, Integer>> songs =
                new ArrayList<>(manySongs.entrySet());

        songs.sort(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : songs) {

            String genre = entry.getKey();

            List<int[]> list = pergenres.get(genre);

            list.sort((a, b) -> {

                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]);
                }

                return Integer.compare(a[0], b[0]);
            });

            answer.add(list.get(0)[0]);

            if (list.size() >= 2) {
                answer.add(list.get(1)[0]);
            }
        }

        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}