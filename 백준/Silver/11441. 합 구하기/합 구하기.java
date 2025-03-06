import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(s[i]);
        }
        int[] sum = new int[N+1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = arr[i]+sum[i-1];
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            bw.write(sum[end]-sum[start-1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}