import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[2*N+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            if(i%2==1)
                dp[i] = (dp[i-1]+dp[i-2])%9901;
            else
                dp[i] = (dp[i-1]+dp[i-3])%9901;
        }
        bw.write(dp[2*N]+"\n");
        bw.flush();
        bw.close();
    }
}