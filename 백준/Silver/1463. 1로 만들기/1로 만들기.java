import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[N]=0;
        for (int i = N; i > 1; i--) {
            if(dp[i]==Integer.MAX_VALUE) continue;
            dp[i-1] = Math.min(dp[i-1],dp[i]+1);
            if(i % 2 == 0) {
                dp[i/2] = Math.min(dp[i/2],dp[i]+1);
            }
            if(i % 3 == 0) {
                dp[i/3] = Math.min(dp[i/3],dp[i]+1);
            }
        }
        bw.write(dp[1]+"\n");
        bw.flush();
        bw.close();
    }
}
