import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        int[] dp = new int[N+2];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        // 해당 날짜를 포함하는 상황에서 최대값 구하기
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]); // 오늘 상담 안 하고 넘어감

            int nextIndex = arr[i][0] + i;
            if(nextIndex > N + 1)
                continue;

            dp[nextIndex] = Math.max(dp[nextIndex], dp[i] + arr[i][1]); // 오늘 상담함
            max = Math.max(max, dp[nextIndex]);
        }
        max = Math.max(max, dp[N]);
        System.out.println(max);
    }
}