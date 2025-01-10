import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] graph = new int[N][2];
        int[][] dp = new int[N+1][K+1];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(s[0]);
            graph[i][1] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(graph[i-1][0]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-graph[i-1][0]]+graph[i-1][1]);
            }
        }
        System.out.println(dp[N][K]);
    }
}