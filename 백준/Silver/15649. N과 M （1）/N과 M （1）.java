import java.io.*;

public class Main {
    static int N,M;
    static int[] result;
    static BufferedWriter bw;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        result = new int[M];
        used = new boolean[N+1];
        combination(0);
        bw.flush();
        bw.close();
    }
    public static void combination(int depth) throws IOException{
        if(depth == M) {
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(used[i])
                continue;
            used[i] = true;
            result[depth] = i;
            combination(depth+1);
            used[i] = false;
        }
    }
}