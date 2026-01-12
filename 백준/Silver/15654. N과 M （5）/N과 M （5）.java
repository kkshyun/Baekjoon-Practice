import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr, result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        perm(0);
        bw.flush();
        bw.close();
    }
    public static void perm(int r) throws IOException {
        if(r == M) {
            for (int i = 0; i < M; i++) {
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            result[r] = arr[i];
            visited[i] = true;
            perm(r+1);
            visited[i] = false;
        }
    }
}