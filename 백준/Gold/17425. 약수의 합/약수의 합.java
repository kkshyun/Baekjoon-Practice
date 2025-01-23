import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        long[] f = new long[1000001];
        for (int i = 1; i < f.length; i++) {
            for (int j = i; j < f.length; j+=i) {
                f[j] += i;
            }
        }
        long[] sum = new long[1000001];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + f[i];
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(sum[num]+"\n");
        }
        bw.flush();
        bw.close();
    }
}