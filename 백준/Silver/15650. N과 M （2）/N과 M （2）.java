import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[] visited;
    static int M;
    static BufferedWriter bw;
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[0] = true;
            memory = new int[N+1];
            dfs(i,1);
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int depth) throws IOException{
        memory[depth] = num;
        if(depth == M) {
            for (int i = 1; i <= M; i++) {
                bw.write(memory[i]+" ");
            }
            bw.write("\n");
        }
        for (int i = num+1; i < visited.length; i++) {
            if(visited[i]==false) {
                visited[i] = true;
                dfs(i,depth+1);
                visited[i] = false;
            }
        }
    }
}