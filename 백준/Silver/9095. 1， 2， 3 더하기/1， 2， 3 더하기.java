import java.io.*;

public class Main {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dp() {
        d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < d.length; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
    }
}
