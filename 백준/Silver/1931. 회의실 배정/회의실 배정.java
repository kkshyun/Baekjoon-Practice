import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            meetings.add(new int[]{start, end});
        }

        Collections.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);  // 종료 시간이 같으면 시작 시간을 기준으로 정렬
            }
            return Integer.compare(a[1], b[1]);  // 종료 시간이 빠른 순으로 정렬
        });
        int lastCheck = 0;
        int count = 0;
        for (int[] meeting : meetings) {
            if(lastCheck<=meeting[0]) {
                count++;
                lastCheck = meeting[1];
            }
        }
        System.out.println(count);
    }
}
