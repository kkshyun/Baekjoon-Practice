import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N+1];
        int[] dp = new int[N+1]; // dp : N개 카드를 구입할 때 최대값
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }
        dp[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            int checkNum = i%2==0?i/2:i/2+1;
            int max = arr[i];
            for (int j = i-1; j >= checkNum; j--) {
                int temp = dp[j] + dp[i - j];
                if(max < temp)
                    max = temp;
            }
            dp[i] = max;
        }
        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }
}