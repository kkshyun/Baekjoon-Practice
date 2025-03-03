import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int stairCount = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairCount+1];
        int[] dp = new int[stairCount+1];
        for (int i = 0; i < stairCount; i++) {
            stairs[i+1] = Integer.parseInt(br.readLine());
        }
        if(stairCount == 1) {
            bw.write(stairs[1]+"\n");
        }
        else {
            dp[0] = 0;
            dp[1] = stairs[1];
            dp[2] = stairs[1]+stairs[2];
            for (int i = 3; i < stairs.length; i++) {
                dp[i] = Math.max(dp[i-2],dp[i-3]+stairs[i-1])+stairs[i];
            }
            bw.write(dp[stairCount]+"\n");
        }
        bw.flush();
        bw.close();
    }
}