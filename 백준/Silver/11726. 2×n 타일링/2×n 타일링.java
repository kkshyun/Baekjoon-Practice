import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] d = new long[1001];
        int num = 10007;
        d[1] = 1%num;
        d[2] = 2%num;
        for (int i = 3; i < d.length; i++) {
            d[i] = (d[i-1]+d[i-2])%num;
        }
        int i = Integer.parseInt(br.readLine());
        bw.write(d[i]+"\n");
        bw.flush();
        bw.close();
    }
}