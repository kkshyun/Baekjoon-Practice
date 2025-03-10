import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i+1] = Integer.parseInt(s[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i],arr[i]);
        }
        dp[0] = Integer.MIN_VALUE;
        Arrays.sort(dp);
        bw.write(dp[dp.length-1]+"\n");
        bw.flush();
        bw.close();
    }
}