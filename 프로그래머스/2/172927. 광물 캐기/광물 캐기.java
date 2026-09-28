import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int pickCount = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, pickCount * 5);

        List<int[]> groups = new ArrayList<>();

        // 5개씩 묶기
        for (int i = 0; i < maxMinerals; i += 5) {

            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < Math.min(i + 5, maxMinerals); j++) {
                if (minerals[j].equals("diamond"))
                    diamond++;
                else if (minerals[j].equals("iron"))
                    iron++;
                else
                    stone++;
            }

            groups.add(new int[]{diamond, iron, stone});
        }

        // 힘든 묶음부터
        groups.sort((a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];

            return b[1] - a[1];
        });

        int answer = 0;

        for (int[] group : groups) {

            if (picks[0] > 0) {
                answer += group[0] + group[1] + group[2];
                picks[0]--;

            } else if (picks[1] > 0) {
                answer += group[0] * 5
                        + group[1]
                        + group[2];
                picks[1]--;

            } else {
                answer += group[0] * 25
                        + group[1] * 5
                        + group[2];
                picks[2]--;
            }
        }

        return answer;
    }
}