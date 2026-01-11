import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[M];
        combination(1,0);
        bw.flush();
        bw.close();
    }
    public static void combination(int start, int r) throws IOException {
        if(r == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[r] = i;
            combination(i, r+1);
        }
    }
}