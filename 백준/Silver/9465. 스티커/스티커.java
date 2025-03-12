import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 0; k < s.length; k++) {
                    arr[j][k] = Integer.parseInt(s[k]);
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(n==1) {
                bw.write(Math.max(dp[0][0],dp[1][0])+"\n");
                continue;
            }
            dp[0][1] = arr[1][0]+arr[0][1];
            dp[1][1] = arr[0][0]+arr[1][1];
            if(n==2) {
                bw.write(Math.max(dp[0][1],dp[1][1])+"\n");
                continue;
            }
            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2])+arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2])+arr[1][j];
            }
            int max1 = Math.max(dp[0][n-2],dp[1][n-2]);
            int max2 = Math.max(dp[0][n-1],dp[1][n-1]);
            bw.write(Math.max(max1,max2)+"\n");
        }
        bw.flush();
        bw.close();

    }
}