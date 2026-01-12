import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] arr,result;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N];
        result = new int[M];
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        combination(0,0);
        bw.flush();
        bw.close();
    }
    public static void combination(int start, int r) throws IOException {
        if(r == M) {
            for (int i = 0; i < M; i++) {
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result[r] = arr[i];
            combination(i+1, r+1);
        }
    }
}