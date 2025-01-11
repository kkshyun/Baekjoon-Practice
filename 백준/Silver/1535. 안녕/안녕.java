import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][2];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            graph[i][0] = Integer.parseInt(s[i-1]);
        }
        s = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            graph[i][1] = Integer.parseInt(s[i-1]);
        }
        int[][] dp = new int[N+1][100];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 99; j++) {
                if(graph[i][0]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-graph[i][0]]+graph[i][1]);

            }
        }
        System.out.println(dp[N][99]);
    }
}