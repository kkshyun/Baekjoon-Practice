import java.io.*;
import java.util.ArrayList;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp = new int[41][2];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] target = fibo(N);
            bw.write(target[N][0]+" "+target[N][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int[][] fibo(int N) {
        if(N==0) {
            dp[N][0] = 1;
            dp[N][1] = 0;
            return dp;
        }
        if(N==1) {
            dp[N][0] = 0;
            dp[N][1] = 1;
            return dp;
        }
        if(dp[N][0]!=0||dp[N][1]!=0)
            return dp;

        int count0 = fibo(N-1)[N-1][0] + fibo(N-2)[N-2][0];
        int count1 = fibo(N-1)[N-1][1] + fibo(N-2)[N-2][1];
        dp[N][0] = count0;
        dp[N][1] = count1;
        return dp;
    }
}