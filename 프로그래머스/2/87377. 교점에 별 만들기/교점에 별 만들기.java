import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<String> points = new HashSet<>();

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];

                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long denominator = A * D - B * C;

                // 평행하거나 일치하는 직선이면 교점 없음
                if (denominator == 0) {
                    continue;
                }

                long xNumerator = B * F - E * D;
                long yNumerator = E * C - A * F;

                // 정수 교점이 아니면 제외
                if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
                    continue;
                }

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                points.add(x + "," + y);

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        List<String> result = new ArrayList<>();

        for (long y = maxY; y >= minY; y--) {
            StringBuilder sb = new StringBuilder();

            for (long x = minX; x <= maxX; x++) {
                if (points.contains(x + "," + y)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }

            result.add(sb.toString());
        }

        return result.toArray(new String[0]);
    
    }
}